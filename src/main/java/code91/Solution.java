package code91;

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.charAt(0) - '0' == 0) {
                return 0;
            }
            return 1;
        }

        int n = s.length();
        int[] dp = new int[s.length() + 1];
        char[] chs = s.toCharArray();
        if (chs[0] == '0') {
            dp[0] = 0;
            dp[1] = 0;
        }else{
            dp[0] = 1;
            dp[1] = 1;
        }
        int pre = s.charAt(0) - '0';

        for (int i = 2; i <= n; i++) {
            int cur = chs[i - 1] - '0';
            if (pre == 0) {
                if (cur == 0) {
                    return 0;
                }
                dp[i] = dp[i - 1];
            } else if (pre == 1) {
                if (cur == 0) {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            } else if (pre == 2) {
                if (cur == 0) {
                    dp[i] = dp[i - 2];
                } else if (cur >= 7) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
            pre = cur;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numDecodings = solution.numDecodings("230");
        System.out.println(numDecodings);
    }
}
