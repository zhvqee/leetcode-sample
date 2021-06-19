package code669;

public class Solution {
    public class TreeNode {
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


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        int val = root.val;
        if (low <= val && val <= high) {
            TreeNode p = root;
            TreeNode pre = p;
            while (p != null && p.left != null) {
                if (p.val >= low) {
                    pre = p;
                    p = p.left;
                } else {
                    break;
                }
            }
            if (p.val < low) {
                pre.left = p.right;
                p.right = null;
                if (pre.left != null)
                    return trimBST(root, low, high);
            }


            p = root;
            pre = p;
            while (p != null && p.right != null) {
                if (p.val <= high) {
                    pre = p;
                    p = p.right;
                } else {
                    break;
                }
            }
            if (p.val > high) {
                pre.right = p.left;
                p.left = null;
                if (pre.right != null)
                    return trimBST(root, low, high);
            }

        } else if (val < low) {
            TreeNode pre = root;
            root = root.right;
            pre.right = null;
            return trimBST(root, low, high);
        } else if (val > high) {
            TreeNode pre = root;
            root = root.left;
            pre.left = null;
            return trimBST(root, low, high);
        }
        return root;
    }

    public TreeNode createTree(int low, int high, Integer[] nums) {
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


        Solution solution = new Solution();
        Integer[] nums = new Integer[]{null, null, null, 0, 1, 2, null, 3, null, null, null, 4, null, null, null};
        TreeNode solutionTree = solution.createTree(0, nums.length - 1, nums);
        System.out.println(solutionTree);
        TreeNode treeNode = solution.trimBST(solutionTree, 1, 3);
        System.out.println(treeNode);
    }
}
