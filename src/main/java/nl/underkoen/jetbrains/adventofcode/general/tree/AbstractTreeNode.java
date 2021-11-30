package nl.underkoen.jetbrains.adventofcode.general.tree;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractTreeNode<T extends TreeNode, P extends TreeNode> implements TreeNode {
    protected final P parent;
    protected Vector<T> list;

    public AbstractTreeNode(P parent) {
        this.parent = parent;
    }

    public Vector<T> getList() {
        if (list == null) list = construct();
        return list;
    }

    protected abstract Vector<T> construct();

    @Override
    public TreeNode getChildAt(int childIndex) {
        return getList().get(childIndex);
    }

    @Override
    public int getChildCount() {
        return getList().size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return getList().indexOf(node);
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
        return getList().elements();
    }
}
