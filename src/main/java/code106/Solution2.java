package code106;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

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

    private int postRootIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postRootIdx = postorder.length - 1;
        return buildTree2(inorderMap, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(Map<Integer, Integer> inorderMap, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postRootIdx]);
        Integer idx = inorderMap.get(postorder[postRootIdx]);
        postRootIdx--;
        treeNode.right = buildTree2(inorderMap, postorder, idx + 1, end);
        treeNode.left = buildTree2(inorderMap, postorder, start, idx - 1);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 中序遍历 inorder = [9,3,15,20,7]
        // 后序遍历 postorder = [9,15,7,20,3]
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
