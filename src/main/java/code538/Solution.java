package code538;

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

    public TreeNode createTree(Integer[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return null;
        }
        if (nums[mid] == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = createTree(nums, low, mid - 1);
        treeNode.right = createTree(nums, mid + 1, high);
        return treeNode;
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode ret = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        int sum = 0;
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                deque.addLast(root);
                root = root.right;
            } else {
                root = deque.pollLast();
                sum += root.val;
                root.val = sum;
                root = root.left;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] nums = new Integer[]{null,0,null, 1, null, 2, 3, 4, null, 5,null, 6, null, 7, 8};
        TreeNode tree = solution.createTree(nums, 0, nums.length - 1);
        System.out.println(tree);
        TreeNode treeNode = solution.convertBST(tree);
        System.out.println(treeNode);
    }
}
