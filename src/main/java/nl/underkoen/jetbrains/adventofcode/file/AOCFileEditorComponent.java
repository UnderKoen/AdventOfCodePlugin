package nl.underkoen.jetbrains.adventofcode.file;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.jcef.JBCefBrowser;
import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefLoadHandlerAdapter;
import org.cef.network.CefRequest;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

@Getter
public class AOCFileEditorComponent extends JPanel {
    private final Day file;
    private final JBCefBrowser browser;

    public AOCFileEditorComponent(Day file) {
        super(new BorderLayout());

        this.file = file;
        browser = new JBCefBrowser(getUrl());

        ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.EDITOR_TOOLBAR, (ActionGroup) ActionManager.getInstance().getAction("aoc-challenge"), true);
        toolbar.setTargetComponent(this);

        add(toolbar.getComponent(), BorderLayout.NORTH);
        add(browser.getComponent(), BorderLayout.CENTER);
    }

    public String getUrl() {
        return String.format("https://adventofcode.com/%s/day/%s", file.getYear().getYear(), file.getDay());
    }
}
