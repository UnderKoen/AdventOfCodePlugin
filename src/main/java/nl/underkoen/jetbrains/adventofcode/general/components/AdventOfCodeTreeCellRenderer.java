package nl.underkoen.jetbrains.adventofcode.general.components;

import com.intellij.ui.JBColor;
import com.intellij.ui.treeStructure.Tree;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import nl.underkoen.jetbrains.adventofcode.general.Year;
import nl.underkoen.jetbrains.adventofcode.general.components.DayPanel;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class AdventOfCodeTreeCellRenderer implements TreeCellRenderer {
    private final TreeCellRenderer cellRenderer;

    public AdventOfCodeTreeCellRenderer(Tree tree) {
        this.cellRenderer = tree.getCellRenderer();
        tree.setCellRenderer(this);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (value instanceof Day) {
            return new DayPanel((Day) value);
        } else if (value instanceof Year) {
            Year year = (Year) value;

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel stars = new JLabel(year.starsText());
            stars.setForeground(JBColor.yellow);
            stars.setFont(stars.getFont().deriveFont(Font.BOLD));

            JLabel text = new JLabel(year.toString());
            text.setFont(text.getFont().deriveFont(Font.BOLD));

            panel.add(text);
            panel.add(stars);

            return panel;
        }
        return cellRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
    }
}
