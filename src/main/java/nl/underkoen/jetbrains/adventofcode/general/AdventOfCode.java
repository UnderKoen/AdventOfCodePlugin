package nl.underkoen.jetbrains.adventofcode.general;

import nl.underkoen.jetbrains.adventofcode.general.tree.AbstractTreeNode;

import javax.swing.tree.TreeNode;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Vector;

public class AdventOfCode extends AbstractTreeNode<Year, TreeNode> {
    public AdventOfCode() {
        super(null);
    }

    protected Vector<Year> construct() {
        Vector<Year> years = new Vector<>();

        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC-5")).plusDays(1);
        int year = dateTime.getYear();
        if (dateTime.getMonth() != Month.DECEMBER) year--;

        for (int i = 2015; i <= year; i++) {
            years.add(new Year(i, this));
        }
        return years;
    }

    @Override
    public String toString() {
        return "AdventOfCode";
    }
}
