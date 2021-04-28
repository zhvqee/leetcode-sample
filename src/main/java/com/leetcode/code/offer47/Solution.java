package com.leetcode.code.offer47;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {
        doSwrapTree(root);
        return root;
    }

    void doSwrapTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return;
        }

        TreeNode p = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = p;

        doSwrapTree(treeNode.left);
        doSwrapTree(treeNode.right);
    }
}
