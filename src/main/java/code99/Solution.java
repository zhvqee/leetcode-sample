package code99;

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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }

        if (root.left != null && root.right == null) {
            if (root.val < root.left.val) {
                int val = root.val;
                root.val = root.left.val;
                root.left.val = val;
            }
            recoverTree(root.left);
        } else if (root.left == null) {
            if (root.val > root.right.val) {
                int val = root.val;
                root.val = root.right.val;
                root.right.val = val;
            }
            recoverTree(root.right);
        } else {
            int left = root.left.val;
            int right = root.right.val;
            int val = root.val;
            if (left > val) {
                root.left.val = val;
                root.val = left;
            }
            if (right < val) {
                root.right.val = val;
                root.val = right;
            }
            recoverTree(root.left);
            recoverTree(root.right);
        }
    }
}
