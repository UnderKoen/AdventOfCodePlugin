package nl.underkoen.jetbrains.adventofcode.file;

import com.intellij.credentialStore.CredentialAttributes;
import com.intellij.credentialStore.CredentialAttributesKt;
import com.intellij.credentialStore.Credentials;
import com.intellij.ide.passwordSafe.PasswordSafe;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.ui.jcef.JBCefCookie;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefLoadHandlerAdapter;
import org.cef.network.CefRequest;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.List;

public class AOCFileEditor implements FileEditor, DumbAware {
    private final Day file;
    private final AOCFileEditorComponent component;

    public AOCFileEditor(Day file) {
        this.file = file;
        component = new AOCFileEditorComponent(file);

        JBCefBrowser browser = component.getBrowser();
        browser.getJBCefClient().addLoadHandler(new CefLoadHandlerAdapter() {
            @Override
            public void onLoadStart(CefBrowser cefBrowser, CefFrame frame, CefRequest.TransitionType transitionType) {
                PropertiesComponent properties = PropertiesComponent.getInstance();
                float zoom = properties.getFloat("zoom", 0.0f);
                cefBrowser.setZoomLevel(zoom);
            }
        }, browser.getCefBrowser());

        CredentialAttributes credentialAttributes = createCredentialAttributes();
        String password = PasswordSafe.getInstance().getPassword(credentialAttributes);
        if (password == null) return;
        browser.getJBCefCookieManager().setCookie("https://adventofcode.com", new JBCefCookie(
                "session",
                password,
                ".adventofcode.com",
                "/",
                true,
                false
        ), false);
    }

    @Override
    public @NotNull JComponent getComponent() {
        return component;
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return null;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) @NotNull String getName() {
        return "AdventOfCode";
    }

    @Override
    public void setState(@NotNull FileEditorState state) {

    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public @Nullable FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {
        List<JBCefCookie> cookies = component.getBrowser().getJBCefCookieManager().getCookies();
        if (cookies == null) return;

        cookies.removeIf(cookie -> !cookie.getDomain().equals(".adventofcode.com"));
        cookies.removeIf(cookie -> !cookie.getName().equals("session"));

        if (cookies.size() == 0) return;;

        JBCefCookie session = cookies.get(0);

        CredentialAttributes credentialAttributes = createCredentialAttributes();
        Credentials credentials = new Credentials("", session.getValue());
        PasswordSafe.getInstance().set(credentialAttributes, credentials);
    }

    private static CredentialAttributes createCredentialAttributes() {
        return new CredentialAttributes(
                CredentialAttributesKt.generateServiceName("MySystem", "AdventOfCode")
        );
    }

    @Override
    public <T> @Nullable T getUserData(@NotNull Key<T> key) {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

    }

    @Override
    public @Nullable VirtualFile getFile() {
        return file;
    }
}
