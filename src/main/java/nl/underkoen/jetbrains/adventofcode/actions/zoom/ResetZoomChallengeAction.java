package nl.underkoen.jetbrains.adventofcode.actions.zoom;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

public class ResetZoomChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (component == null) return;
        browser.setZoomLevel(0.0f);
        PropertiesComponent.getInstance().setValue("zoom", 0.0f, 0.0f);
    }
}
