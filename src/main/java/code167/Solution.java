package code167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int s = numbers[l] + numbers[r];
            if (s == target) {
                return new int[]{l + 1, r + 1};
            } else if (s > target) {
                r--;
            } else {
                l--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{5, 25, 75}, 100);
    }
}

