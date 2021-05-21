package code700;

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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        TreeNode treeNode = searchBST(root.left, val);
        if (treeNode != null) {
            return treeNode;
        }
        return searchBST(root.right, val);
    }
}


