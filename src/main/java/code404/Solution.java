package code404;

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


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        int sum = 0;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                if (pre !=null && pre.left == root&& root.left == null && root.right == null) {
                    sum += root.val;
                }
                stack.addLast(root);
                pre = root;
                root = root.left;
            } else {
                root = stack.pollLast();
                pre = root;
                root = root.right;
            }
        }
        return sum;
    }
}
