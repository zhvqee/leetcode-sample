package code.offer07;

import java.util.HashMap;
import java.util.Map;

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

    private int preStart = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return construct(preorder, inOrderMap, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, Map<Integer, Integer> inOrderMap, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preStart]);

        Integer idx = inOrderMap.get(preorder[preStart]);

        preStart++;

        head.left = construct(preorder, inOrderMap, inStart, idx - 1);
        head.right = construct(preorder, inOrderMap, idx + 1, inEnd);
        return head;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        //前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]

        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
