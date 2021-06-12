package code669;

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


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        TreeNode treeNode = disMin(root, low);
        if (treeNode == null) {
            TreeNode p = root.right;
            root.right = null;
            root = p;
        }

        return disMax(root, high);
    }

    TreeNode disMax(TreeNode root, int high) {
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        TreeNode pre = root;
        while (p != null && p.val <= high) {
            pre = p;
            p = p.right;
        }
        if (p == root) {
            return null;
        }
        pre.right = null;
        return root;

    }

    TreeNode disMin(TreeNode root, int low) {
        if (root == null) {
            return root;
        }
        TreeNode p = root;
        TreeNode pre = root;
        //找到比low 小的节点，则包括p节点和 其左子树都要删除。
        while (p != null && p.val >= low) {
            pre = p;
            p = p.left;
        }
        if (p == root) {
            return null;
        }
        if (p != null) {
            pre.left = p.right;
            p.right = null;
        }
        return root;
    }
}
