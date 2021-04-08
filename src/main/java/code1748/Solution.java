package code1748;

public class Solution {

    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) {
            cnt[n]++;
        }
        int sum = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sumOfUnique = solution.sumOfUnique(new int[]{1, 2, 3, 4, 5});
        System.out.println(sumOfUnique);
    }
}
