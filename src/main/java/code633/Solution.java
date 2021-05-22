package code633;

public class Solution {

    public boolean judgeSquareSum(int c) {

        int max = (int) Math.sqrt(c);
        int l = 0, r = max;
        while (l <= r) {
            int s = l * l + r * r;
            if (s == c) {
                return true;
            }
            if (s > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean judgeSquareSum = solution.judgeSquareSum(4);
        System.out.println(judgeSquareSum);
    }
}
