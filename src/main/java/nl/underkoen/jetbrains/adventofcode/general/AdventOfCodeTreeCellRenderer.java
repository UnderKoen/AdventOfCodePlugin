package nl.underkoen.jetbrains.adventofcode.general;

import com.intellij.ui.JBColor;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class AdventOfCodeTreeCellRenderer implements TreeCellRenderer {
    private final TreeCellRenderer cellRenderer;

    public AdventOfCodeTreeCellRenderer(JTree tree) {
        this.cellRenderer = tree.getCellRenderer();
        tree.setCellRenderer(this);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (value instanceof Day) {
            Day day = (Day) value;

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel stars = new JLabel(day.starsString());
            stars.setForeground(JBColor.yellow);
            stars.setFont(stars.getFont().deriveFont(Font.BOLD));

            panel.add(new JLabel(day.toString()));
            panel.add(stars);
            return panel;
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
