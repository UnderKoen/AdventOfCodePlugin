package nl.underkoen.jetbrains.adventofcode.general;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFileSystem;
import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.file.VirtualDirectory;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.TreeNode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Enumeration;
import java.util.Vector;

@Getter
public class Year extends VirtualDirectory implements TreeNode {
    private final Vector<Day> days;
    private final int year;
    private final AdventOfCode adventOfCode;

    public Year(int year, AdventOfCode adventOfCode) {
        super(null, null);
        this.year = year;
        this.days = construct();
        setFiles(days);
        this.adventOfCode = adventOfCode;
    }

    @Override
    public String toString() {
        return String.format("Year %s", year);
    }

    protected Vector<Day> construct() {
        Vector<Day> days = new Vector<>();

        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC-5")).plusDays(1);
        int day = 25;
        if (dateTime.getYear() == year) day = Math.min(dateTime.getDayOfMonth(), 25);

        for (int i = 1; i <= day; i++) {
            days.add(new Day(i, this));
        }
        return days;
    }

    public Day getDay(int day) {
        return days.get(day);
    }

    public int stars() {
        return days.stream()
                .mapToInt(Day::stars)
                .sum();
    }

    public String starsText() {
        int stars = stars();
        if (stars == 0) return "";
        return String.format("%02d *", stars);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return getDay(childIndex);
    }

    @Override
    public int getChildCount() {
        return days.size();
    }

    @Override
    public @NotNull @NlsSafe String getName() {
        return toString();
    }

    @Override
    public @NotNull VirtualFileSystem getFileSystem() {
        return adventOfCode.getRoot();
    }

    @Override
    public AdventOfCode getParent() {
        return adventOfCode;
    }

    @Override
    public int getIndex(TreeNode node) {
        return days.indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return days.elements();
    }
}
