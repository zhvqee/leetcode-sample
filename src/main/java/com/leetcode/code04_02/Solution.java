package com.leetcode.code04_02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTree(0, nums.length - 1, nums);
    }

    private TreeNode createTree(int low, int high, int[] nums) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low + 1) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = createTree(low, mid - 1, nums);
        treeNode.right = createTree(mid + 1, high, nums);
        return treeNode;
    }


    public void print(TreeNode treeNode) {
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            System.out.print(pop.val + " ");
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        solution.print(treeNode);
    }
}
