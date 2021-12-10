package nl.underkoen.jetbrains.adventofcode.actions.zoom;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import nl.underkoen.jetbrains.adventofcode.actions.BrowserAction;
import org.jetbrains.annotations.NotNull;

public class ZoomInChallengeAction extends BrowserAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Logger.getInstance(getClass()).warn(e.toString());
        if (component == null) return;
        PropertiesComponent properties = PropertiesComponent.getInstance();
        float zoom = properties.getFloat("zoom", 0.0f);
        zoom += 0.1;
        browser.setZoomLevel(zoom);
        properties.setValue("zoom", zoom, 0.0f);
    }
}
