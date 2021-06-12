package code55;

public class Solution {

    public int change(int amount, int[] coins) {
        int result[] = {0};
        dfs(0, coins, amount, 0, result);
        return result[0];
    }

    private void dfs(int k, int[] coins, int amount, int current, int[] result) {
        if (current == amount) {
            result[0]++;
            return;
        }
        if (current > amount) {
            return;
        }
        int len = coins.length;
        for (int i = k; i < len; i++) {
            dfs(i, coins, amount, current + coins[i], result);
        }
    }

//500,35502874
//[3,5,7,8,9,10,11]
    public static void main(String[] args) {
        Solution solution = new Solution();
        int change = solution.change(500, new int[]{3,5,7,8,9,10,11});
        System.out.println(change);
    }


}
