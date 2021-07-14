package code1008;

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

    /**
     * 前序 ，根， 左子树，右子树
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        return constructTree(preorder, 0, preorder.length - 1);
    }

    TreeNode constructTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[start]);
        int left;
        for (left = start + 1; left <= end; ) {
            if (preorder[start] > preorder[left]) {
                left++;
            } else {
                break;
            }
        }
        head.left = constructTree(preorder, start + 1, left - 1);
        head.right = constructTree(preorder, left, end);
        return head;
    }
}
