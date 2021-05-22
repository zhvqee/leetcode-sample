package code135;

public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1]) {
                candy[i] = candy[i - 1] + 1;

            }
        }
        int cnt = 0;
        for (int i = 0; i < candy.length; i++) {
            cnt += candy[i];
            System.out.print((candy[i] + 1) + " ");
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int candy = solution.candy(new int[]{1, 2, 87, 87, 87, 2, 1});
        System.out.println(candy);
    }
}
