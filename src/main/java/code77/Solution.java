package code77;

public class Solution {

    // dp[i][j] 代表word1 i位置，word2 j位置编辑
    public int minDistance(String word1, String word2) {
        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j <= len1; j++) {
            dp[j][0] = j;
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (wordArr1[i - 1] == wordArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 对插入i, 删除i， 替换
                    dp[i][j] = getMin(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;

                }
            }
        }
        return dp[len1][len2];
    }

    private int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minDistance("AVC", "A");
        System.out.println(i);
    }

}
