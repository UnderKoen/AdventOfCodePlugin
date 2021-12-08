package nl.underkoen.jetbrains.adventofcode.general.components;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import nl.underkoen.jetbrains.adventofcode.general.Day;

import javax.swing.*;
import java.awt.*;

public class DayPanel extends JPanel {
    private static final Logger log = Logger.getInstance(DayPanel.class);

    public DayPanel(Day day) {
        super();

        Box horizontalBox = Box.createHorizontalBox();
        add(horizontalBox);

        JLabel stars = new JBLabel(day.starsString(), SwingConstants.CENTER);
        stars.setForeground(JBColor.yellow);
        stars.setFont(stars.getFont().deriveFont(Font.BOLD));

        horizontalBox.add(new JBLabel(day.toString(), SwingConstants.CENTER));
        horizontalBox.add(stars);
    }
}
