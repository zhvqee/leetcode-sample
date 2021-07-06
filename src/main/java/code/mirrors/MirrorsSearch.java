package code.mirrors;


public class MirrorsSearch {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void search(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
            cur = cur.left;
        }

    }
}
