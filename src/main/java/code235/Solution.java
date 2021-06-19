package code235;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;

    }
}
