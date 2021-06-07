package code64;

public class Solution {
    // dp[i][j] 代表已i，j为右下角，的最少到大值
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
