package nl.underkoen.jetbrains.adventofcode.actions.navigation;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HomeChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (component == null) return;
        while (browser.canGoBack()) browser.goBack();
    }

    @Override
    protected void setPresentation(Presentation presentation) {
        presentation.setEnabled(!Objects.equals(browser.getURL(), component.getUrl()));
    }
}
