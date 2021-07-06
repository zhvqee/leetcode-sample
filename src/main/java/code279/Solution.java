package code279;

public class Solution {
    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrt; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int numSquares = solution.numSquares(13);
        System.out.println(numSquares);
    }
}
