package code543;

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

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        depth(root, max);
        return max[0];
    }

    private int depth(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left, max);
        int rightDepth = depth(root.right, max);

        if (leftDepth + rightDepth > max[0]) {
            max[0] = leftDepth + rightDepth;
        }
        return Math.max(depth(root.left, max), depth(root.right, max)) + 1;
    }
}
