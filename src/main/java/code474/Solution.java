package code474;

public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        int len = strs.length;
        for (int k = 1; k <= len; k++) {
            int[] counts = getCount(strs[k - 1]);
            for (int i = 0; i <= m; i++) { // i个0
                for (int j = 0; j <= n; j++) { // j个1；
                    if (i >= counts[0] && j >= counts[1]) {
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - counts[0]][j - counts[1]] + 1);
                    } else {
                        dp[k][i][j] = dp[k - 1][i][j];
                    }
                }
            }
        }
        return dp[strs.length][m][n];

    }

    private int[] getCount(String s) {
        int czero = 0, cone = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cone++;
            } else {
                czero++;
            }
        }
        return new int[]{czero, cone};
    }

    /**
     * ["11111","100","1101","1101","11000"]
     * 5
     * 7
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution= new Solution();
        int maxForm = solution.findMaxForm(new String[]{"11111", "100", "1101", "1101", "11000"}, 5, 7);
        System.out.println(maxForm);
    }
}