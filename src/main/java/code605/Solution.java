package code605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int max = (int) Math.round(len / 2.0);
        if (max < n) {
            return false;
        }
        if (n == 0) {
            return true;
        }

        int cnt = 0;
        for (int i = 0; i < len; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if ((i + 1 < len && flowerbed[i + 1] == 0) || (i == len - 1)) {
                    i += 2;
                    cnt++;
                }else{
                    i++;
                }
            }
            if (cnt == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }


}
