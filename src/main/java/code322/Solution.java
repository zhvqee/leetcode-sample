package code322;

public class Solution {
    // dp[i][j] 定义，i种币，兑换金额j的所需的最少数列
    //dp[coins.length][amount]

    //dp[i][j]= dp[i-1][j], dp[i][j-coins[i]]+1;
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = amount + 2;
        }
        dp[0][0] = 0;

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }else{
                    dp[i][j]=dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount] == amount + 2 ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int coinChange = solution.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(coinChange);
    }
}
