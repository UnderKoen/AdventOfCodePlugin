package nl.underkoen.jetbrains.adventofcode.general.tree;

import lombok.RequiredArgsConstructor;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

@RequiredArgsConstructor
public class TreeLeaf<T extends TreeNode> implements TreeNode {
    protected final T parent;

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }
}
