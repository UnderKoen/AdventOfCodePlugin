package nl.underkoen.jetbrains.adventofcode.toolwindows;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.treeStructure.SimpleTree;
import nl.underkoen.jetbrains.adventofcode.general.AdventOfCode;
import nl.underkoen.jetbrains.adventofcode.general.AdventOfCodeTreeCellRenderer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class AdventOfCodeViewer {
    private final SimpleTree list = new SimpleTree(new DefaultTreeModel(new AdventOfCode()));

    public AdventOfCodeViewer(ToolWindow toolWindow) {
        new AdventOfCodeTreeCellRenderer(list);
    }

    public JComponent getContent() {
        return list;
    }
}
