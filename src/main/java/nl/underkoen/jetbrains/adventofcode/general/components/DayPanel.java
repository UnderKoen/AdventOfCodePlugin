package nl.underkoen.jetbrains.adventofcode.general.components;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.ui.JBColor;
import nl.underkoen.jetbrains.adventofcode.general.Day;

import javax.swing.*;
import java.awt.*;

public class DayPanel extends JPanel {
    private static final Logger log = Logger.getInstance(DayPanel.class);

    public DayPanel(Day day) {
        super(new FlowLayout(FlowLayout.LEFT));

        JLabel stars = new JLabel(day.starsString(), SwingConstants.CENTER);
        stars.setForeground(JBColor.yellow);
        stars.setFont(stars.getFont().deriveFont(Font.BOLD));

        add(new JLabel(day.toString()));
        add(stars);
    }
}
