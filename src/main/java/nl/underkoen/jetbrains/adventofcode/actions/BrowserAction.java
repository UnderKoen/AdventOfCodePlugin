package nl.underkoen.jetbrains.adventofcode.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.ui.jcef.JBCefBrowser;
import nl.underkoen.jetbrains.adventofcode.file.AOCFileEditorComponent;
import org.cef.browser.CefBrowser;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public abstract class BrowserAction extends AnAction {
    protected AOCFileEditorComponent component;
    protected CefBrowser browser;
    protected JBCefBrowser jbBrowser;

    @Override
    public void update(@NotNull AnActionEvent e) {
        Component c = e.getDataContext().getData(PlatformDataKeys.CONTEXT_COMPONENT);

        if (c instanceof AOCFileEditorComponent) {
            component = (AOCFileEditorComponent) c;
            jbBrowser = component.getBrowser();
            browser = jbBrowser.getCefBrowser();
        } else if (component == null) {
            e.getPresentation().setEnabled(false);
            return;
        }

        setPresentation(e.getPresentation());
    }

    protected void setPresentation(Presentation presentation) {
        presentation.setEnabled(true);
    }
}
