package code.mirrors;


import java.util.ArrayDeque;
import java.util.Queue;

public class MirrorsSearch {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(String[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTree(nums, 0);
    }

    public TreeNode createTree(String[] nums, int i) {
        if (i == nums.length) {
            return null;
        }
        if (nums[i].equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(nums[i]));
        treeNode.left = createTree(nums, i + 1);
        treeNode.right = createTree(nums, i + 2);
        return treeNode;
    }


    public void print(TreeNode treeNode) {
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            System.out.print(pop.val + " ");
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
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

    public static void main(String[] args) {
        MirrorsSearch search = new MirrorsSearch();
        String[] nums = new String[]{"1","2","3","4","5","6","7","#","#","8","#","#","#","#","#"};
        TreeNode tree = search.sortedArrayToBST(nums);
        System.out.println(tree);
    }
}
