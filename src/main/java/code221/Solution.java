package code221;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int n = matrix.length;
        int m = matrix[0].length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (j == 0) {
                    dp[i][0] = matrix[i][j] == '1' ? 1 : 0;

                } else {
                    int v = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                    dp[i][j] = matrix[i][j] == '1' ? v + 1 : v;
                }
                size = Math.max(size, dp[i][j]);
            }
        }
        return size * size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[["0","1"],["1","0"]]
        char[][] a = {
                {'0', '1'},
                {'1', '0'}
        };
        int maximalSquare = solution.maximalSquare(a);
        System.out.println(maximalSquare);
    }

}
