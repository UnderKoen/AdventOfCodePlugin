package nl.underkoen.jetbrains.adventofcode.general;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFileSystem;
import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.file.VirtualDirectory;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.TreeNode;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Enumeration;
import java.util.Vector;

public class AdventOfCode extends VirtualDirectory implements TreeNode {
    @Getter private final AOCTreeModal root;
    private final Vector<Year> years;

    public AdventOfCode(AOCTreeModal root) {
        super(null, null);
        this.root = root;
        this.years = construct();
        setFiles(years);
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

    public Year getYear(int year) {
        return years.get(year - 2015);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return years.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return years.size();
    }

    @Override
    public @NotNull @NlsSafe String getName() {
        return "AdventOfCode";
    }

    @Override
    public @NotNull VirtualFileSystem getFileSystem() {
        return root;
    }

    @Override
    public AdventOfCode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return years.indexOf(node);
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
        return years.elements();
    }

    @Override
    public String toString() {
        return getName();
    }
}
