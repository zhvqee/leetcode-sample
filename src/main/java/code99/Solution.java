package code99;

import java.util.ArrayDeque;
import java.util.Deque;

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
        TreeNode error1 = null;
        TreeNode error2 = null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !queue.isEmpty()) {
            if (p != null) {
                queue.addLast(p);
                p = p.left;
            } else {
                p = queue.pop();
                if (pre != null && pre.val >= p.val) {
                    if (error1 == null) {
                        error1 = pre;
                        error2 = root;
                    } else {
                        error2 = root;
                    }
                }
                pre = p;
                p = p.right;
            }
        }

        int t = error1.val;
        error1.val = error2.val;
        error2.val = t;
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
        Solution solution= new Solution();//solution.createTree(0,)
    }
}
