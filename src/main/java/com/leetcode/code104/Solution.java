package com.leetcode.code104;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        return depth(root);
    }

    int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }

        int lefDepth = 0;
        if (treeNode.left != null) {
            lefDepth = depth(treeNode.left) + 1;
        }
        int rightDepth = 0;
        if (treeNode.right != null) {
            rightDepth = depth(treeNode.right) + 1;
        }
        return Math.max(lefDepth, rightDepth);
    }
}
