package nl.underkoen.jetbrains.adventofcode.actions.zoom;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

public class ZoomOutChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (component == null) return;
        PropertiesComponent properties = PropertiesComponent.getInstance();
        float zoom = properties.getFloat("zoom", 0.0f);
        zoom -= 0.1;
        browser.setZoomLevel(zoom);
        properties.setValue("zoom", zoom, 0.0f);
    }
}
