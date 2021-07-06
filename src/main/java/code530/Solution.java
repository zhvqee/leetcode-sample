package code530;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public int getMinimumDifference(TreeNode root) {
        Integer min = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (root != null || !queue.isEmpty()) {
            if (root != null) {
                queue.addLast(root);
                root = root.left;
            } else {
                root = queue.pollLast();
                if (pre != null) {
                    int value = Math.abs(pre.val - root.val);
                    min = Math.min(value, min);
                }
                pre = root;
                root = root.right;
            }
        }
        return min;
    }


    public TreeNode createTree(int low, int high, Integer[] nums) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low + 1) / 2;
        if (nums[mid] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = createTree(low, mid - 1, nums);
        treeNode.right = createTree(mid + 1, high, nums);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] nums = new Integer[]{null, null, null, null, null, null, null, 0, 519, 1277, null, 2236, null, 2776, null};
        TreeNode tree = solution.createTree(0, nums.length - 1, nums);
        System.out.println(true);
        int minimumDifference = solution.getMinimumDifference(tree);
        System.out.println(minimumDifference);

    }
}
