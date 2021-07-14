package code.offer33;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify(0, postorder.length - 1, postorder);
    }

    // 二叉树 左子树 <根节点 < 右子树
    private boolean verify(int begin, int end, int[] postorder) {
        if (begin >= end) {
            return true;
        }

        int gtBegin = begin;
        while (gtBegin < end && postorder[gtBegin] < postorder[end]) {
            gtBegin++;
        }

        for (int i = gtBegin; i <= end - 1; i++) {
            if (postorder[i] < postorder[end]) {
                return false;
            }
        }
        return verify(begin, gtBegin - 1, postorder) && verify(gtBegin, end-1, postorder);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean verifyPostorder = solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3});
        System.out.println(verifyPostorder);
    }

}
