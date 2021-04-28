package code561;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        for (int i = 0; i < nums.length; i += 2) {
            s += nums[i];
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int arrayPairSum = solution.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2});
        System.out.println(arrayPairSum);
    }

}
