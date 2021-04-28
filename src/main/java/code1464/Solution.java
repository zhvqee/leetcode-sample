package code1464;

public class Solution {
    public int maxProduct(int[] nums) {
        int fMax, sMax;
        if (nums[0] > nums[1]) {
            fMax = nums[0];
            sMax = nums[1];
        } else {
            fMax = nums[1];
            sMax = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > fMax) {
                sMax = fMax;
                fMax = nums[i];
            } else if (nums[i] > sMax) {
                sMax = nums[i];
            }
        }
        return (fMax - 1) * (sMax - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxProduct = solution.maxProduct(new int[]{2, 2, 1, 8, 1, 5, 4, 5, 2, 10, 3, 6, 5, 2, 3});
        System.out.println(maxProduct);
    }
}
