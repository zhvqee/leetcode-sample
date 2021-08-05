package code.mirrors;

public class MirrorsSearch {
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

    public void search(TreeNode treeNode) {
        TreeNode cur = treeNode;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight == null) {
                cur = cur.right;
            } else {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur=cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
            cur = cur.left;
        }

    }

    public static void main(String[] args) {
        MirrorsSearch search = new MirrorsSearch();
        String[] nums = new String[]{"1","2","3","4","5","6","7","#","#","8","#","#","#","#","#"};

    }
}
