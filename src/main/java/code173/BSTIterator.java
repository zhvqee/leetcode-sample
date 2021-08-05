package code173;

import java.util.Stack;

public class BSTIterator {

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

    Stack<TreeNode> stack;

    private TreeNode root;

    private TreeNode next;

    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        this.root = root;
        if (root != null) {
            cur = root;
            stack = new Stack<>();
        }
    }

    private void extracted() {
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                next = cur;
                cur = cur.right;
                break;
            }
        }
    }

    // 中心遍历

    public int next() {
        extracted();
        int retValue = next.val;
        return retValue;
    }

    public boolean hasNext() {
        return !(stack.isEmpty() && cur == null);
    }

    public static TreeNode createTree(int low, int high, Integer[] nums) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low + 1) / 2;
        if (nums[mid] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = createTree(low, mid - 1, nums);
        treeNode.right = createTree(mid + 1, high, nums);
        return treeNode;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{null, 3, null, 7, 9, 15, 20};
        TreeNode treeNode = BSTIterator.createTree(0, nums.length - 1, nums);
        BSTIterator bstIterator = new BSTIterator(treeNode);

        System.out.println(bstIterator.next());    // 返回 3
        System.out.println(bstIterator.next());   // 返回 7
        System.out.println(bstIterator.hasNext()); // 返回 True
        System.out.println(bstIterator.next());   // 返回 9
        System.out.println(bstIterator.hasNext()); // 返回 True
        System.out.println(bstIterator.next());  // 返回 15
        System.out.println(bstIterator.hasNext()); // 返回 True
        System.out.println(bstIterator.next());   // 返回 20
        System.out.println(bstIterator.hasNext()); // 返回 False

    }
}
