package code513;

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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int val = root.val;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (i == 0) {
                    val = poll.val;
                }
                if (poll.left != null) {
                    deque.addLast(poll.left);
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                }
            }
        }
        return val;
    }
}
