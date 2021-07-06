package code110;

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

    public boolean isBalanced2(TreeNode root) {
        return depth2(root) != -1;
    }

    public int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth2(root.left);
        int rightDepth = depth2(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;

    }


    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
