package nl.underkoen.jetbrains.adventofcode.general.tree;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public interface TreeLeaf<T extends TreeNode> extends TreeNode {
    @Override
    default TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    default int getChildCount() {
        return 0;
    }

    @Override
    T getParent();

    @Override
    default int getIndex(TreeNode node) {
        return -1;
    }

    @Override
    default boolean getAllowsChildren() {
        return false;
    }

    @Override
    default boolean isLeaf() {
        return true;
    }

    @Override
    default Enumeration<? extends TreeNode> children() {
        return null;
    }
}
