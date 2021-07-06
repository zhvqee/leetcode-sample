package code437;

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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumWithRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumWithRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = targetSum == root.val ? 1 : 0;
        count += pathSumWithRoot(root.left, targetSum - root.val);
        count += pathSumWithRoot(root.right, targetSum - root.val);
        return count;
    }
}
