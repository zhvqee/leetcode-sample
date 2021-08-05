package code222;

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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            int leftLevel = countLevel(root.left);
            int rightLevel = countLevel(root.right);

            // 如果左子树深度 等于右子树深度，说明左子树是满二叉树，
            if (leftLevel == rightLevel) {
                count += 1 << leftLevel;
                root = root.right;

            } else {
                count += 1 << rightLevel;
                root = root.left;
            }
        }
        return count;
    }

    /**
     * 满二叉树的深度计算
     *
     * @param root
     * @return
     */
    int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
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
        Integer[] nums = new Integer[]{4, 2, 5, 1, 6, 3, null};
        TreeNode tree = solution.createTree(0, nums.length - 1, nums);
        System.out.println(tree);
        int countNodes = solution.countNodes(tree);
        System.out.println(countNodes);
    }
}
