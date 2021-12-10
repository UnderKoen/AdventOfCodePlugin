package nl.underkoen.jetbrains.adventofcode.toolwindows;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.DoubleClickListener;
import com.intellij.ui.treeStructure.Tree;
import nl.underkoen.jetbrains.adventofcode.general.AOCTreeModal;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import nl.underkoen.jetbrains.adventofcode.general.components.AdventOfCodeTreeCellRenderer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class AdventOfCodeViewer {
    private final Tree list;

    public AdventOfCodeViewer(Project project, ToolWindow toolWindow) {
        list = new Tree(new AOCTreeModal());
        list.setCellRenderer(new AdventOfCodeTreeCellRenderer());

        (new DoubleClickListener() {
            @Override
            protected boolean onDoubleClick(@NotNull MouseEvent event) {
                int row = list.getClosestRowForLocation(event.getX(), event.getY());
                if (row == -1) return false;
                Object obj = list.getPathForRow(row).getLastPathComponent();
                if (obj instanceof Day) {
                    Day day = (Day) obj;
                    FileEditorManager.getInstance(project).openFile(day, true);
                    return true;
                }
                return false;
            }
        }).installOn(list);
    }

    public JComponent getContent() {
        return list;
    }
}
