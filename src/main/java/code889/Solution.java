package code889;

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

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length < 1) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        return construct(pre, 0, post.length - 1,post,0,pre.length-1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd,
                               int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode head = new TreeNode(pre[preStart]);
        int i = postStart;

        // i 前面成为 其head 的左子树
        while (i <= postEnd) {
            if (pre[preStart + 1] == post[i]) {
                break;
            }
            i++;
        }
        int len = i - postStart + 1;

        head.left = construct(pre, preStart + 1, preStart + len, post, postStart, i - 1);
        head.right = construct(pre,preStart+1+len,preEnd,post,postStart,i-1);
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //  pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = solution.constructFromPrePost(pre, post);
        System.out.println(treeNode);
    }
}
