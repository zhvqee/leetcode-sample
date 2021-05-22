package code108;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = sortedArrayToBST(nums, l, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, r);
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
