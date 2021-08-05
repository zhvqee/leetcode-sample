package code106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Map<Integer, Integer> postorderMap = new HashMap<>(postorder.length);
        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }

        return buildTree2(inorderMap, postorderMap, postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(Map<Integer, Integer> inorderMap, Map<Integer, Integer> postorderMap,

                                int[] postorder, int postRootIdx, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postRootIdx]);
        Integer idx = inorderMap.get(postorder[postRootIdx]);

        int postRootIdx1 = -1;
        for (int i = start; i <= idx - 1; i++) {
            postRootIdx1 = Math.max(postorderMap.get(inorder[i]), postRootIdx1);
        }

        int postRootIdx2 = -1;
        for (int i = idx + 1; i <= end; i++) {
            postRootIdx2 = Math.max(postorderMap.get(inorder[i]), postRootIdx2);
        }

        treeNode.left = buildTree2(inorderMap, postorderMap, postorder, postRootIdx1, inorder, start, idx - 1);
        treeNode.right = buildTree2(inorderMap, postorderMap, postorder, postRootIdx2, inorder, idx + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 中序遍历 inorder = [9,3,15,20,7]
        // 后序遍历 postorder = [9,15,7,20,3]
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
