package nl.underkoen.jetbrains.adventofcode.general.components;

import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import nl.underkoen.jetbrains.adventofcode.general.Year;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AdventOfCodeTreeCellRenderer extends ColoredTreeCellRenderer {
    @Override
    public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (value instanceof Day) {
            Day day = (Day) value;
            append(day.toString());
        } else if (value instanceof Year) {
            Year year = (Year) value;
            append(String.format("[%s]", year), new SimpleTextAttributes(SimpleTextAttributes.STYLE_BOLD, Colors.GREEN));
        } else {
            append(value.toString(), new SimpleTextAttributes(SimpleTextAttributes.STYLE_BOLD, Colors.LIGHT_GREEN));
        }
    }
}
