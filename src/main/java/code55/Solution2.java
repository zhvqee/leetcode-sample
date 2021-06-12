package code55;

public class Solution2 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int change = solution2.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }

}
