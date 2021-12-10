package nl.underkoen.jetbrains.adventofcode.actions.navigation;

import com.intellij.openapi.actionSystem.AnActionEvent;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

public class RefreshChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (component == null) return;
        browser.reload();
    }
}
