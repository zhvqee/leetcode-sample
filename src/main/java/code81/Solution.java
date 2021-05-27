package code81;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length <= 0) {
            return false;
        }

        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            // 右边有序
            if (nums[mid] == target) {
                return true;
            }
            // 右边有序 增
            if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                //左边有序 增
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] == nums[r]) {
                r = r - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean search = solution.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
        System.out.println(search);
    }
}
