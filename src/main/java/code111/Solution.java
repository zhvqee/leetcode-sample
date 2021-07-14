package code111;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, 1);
    }

    int process(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        if (root.left == null && root.right == null) {
            return level;
        }
        int ans = Integer.MAX_VALUE;

        if (root.left != null) {
            ans = Math.min(process(root.left, level + 1), ans);
        }
        if (root.right != null) {
            ans = Math.min(process(root.right, level + 1), ans);
        }
        return ans;
    }

}
