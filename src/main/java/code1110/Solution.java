package code1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();
        result.add(root);
        Set<Integer> dictSet = new HashSet<>();
        for (int n : to_delete) {
            dictSet.add(n);
        }
        if(dictSet.contains(root.val)){
            deleteNode(root.left, dictSet, result);
            deleteNode(root.right, dictSet, result);
        }else{
            deleteNode(root, dictSet, result);
        }
        return result;
    }

    private void deleteNode(TreeNode root, Set<Integer> deleteNumSet, List<TreeNode> treeNodeList) {
        if (root == null) {
            return;
        }

        deleteNode(root.left, deleteNumSet, treeNodeList);
        deleteNode(root.right, deleteNumSet, treeNodeList);

        if (root.left != null) {
            if (deleteNumSet.contains(root.left.val)) {
                TreeNode newRoot = root.left;
                root.left = null;
                if (newRoot.left != null) {
                    treeNodeList.add(newRoot.left);
                }
                if (newRoot.right != null) {
                    treeNodeList.add(newRoot.right);
                }
                return;
            }
        }
        if (root.right != null) {
            if (deleteNumSet.contains(root.right.val)) {
                TreeNode newRoot = root.right;
                root.right = null;
                if (newRoot.left != null) {
                    treeNodeList.add(newRoot.left);
                }
                if (newRoot.right != null) {
                    treeNodeList.add(newRoot.right);
                }
                return;
            }
        }
    }
}
