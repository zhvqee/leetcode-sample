package code105;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inOrderIndexMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> inOrderIndexMap,
                                     int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        Integer pIndex = inOrderIndexMap.get(preorder[preLeft]);
        root.left = buildTreeHelper(preorder, inOrderIndexMap, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1);
        root.right = buildTreeHelper(preorder, inOrderIndexMap, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight);
        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

}
