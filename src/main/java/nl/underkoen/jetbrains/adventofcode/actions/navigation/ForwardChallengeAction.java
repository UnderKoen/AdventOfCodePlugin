package nl.underkoen.jetbrains.adventofcode.actions.navigation;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

public class ForwardChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (component == null) return;
        if (browser.canGoForward()) browser.goForward();
    }

    @Override
    protected void setPresentation(Presentation presentation) {
        presentation.setEnabled(browser.canGoForward());
    }
}
