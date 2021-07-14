package code145;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 通过 mirrors 遍历 实现后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            //当不存在左子树的时候，直接转向右子树
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    print(cur.left, result);
                }
            }
            // 可能是其又子树，或者来到其父节点
            cur = cur.right;

        }
        return result;
    }

    private void print(TreeNode left, List<Integer> result) {
        TreeNode tail = reverse(left);
        TreeNode cur = tail;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.right;
        }
        reverse(tail);

    }

    private TreeNode reverse(TreeNode head) {
        TreeNode pre = null;
        TreeNode cur = head;
        TreeNode next = null;
        while (cur != null) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
