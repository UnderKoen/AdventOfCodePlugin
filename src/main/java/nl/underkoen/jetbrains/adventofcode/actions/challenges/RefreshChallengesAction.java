package nl.underkoen.jetbrains.adventofcode.actions.challenges;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.ui.treeStructure.Tree;
import nl.underkoen.jetbrains.adventofcode.general.AOCTreeModal;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class RefreshChallengesAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Component c = e.getDataContext().getData(PlatformDataKeys.CONTEXT_COMPONENT);

        if (!(c instanceof Tree)) return;

        Tree tree = (Tree) c;
        tree.setModel(new AOCTreeModal());
    }
}
