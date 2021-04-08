package code17;

public class Solution {

    public int[] printNumbers(int n) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s = s * 10 + 9;
        }
        int[] ret = new int[s];
        for (int i = 1; i <= s; i++) {
            ret[i - 1] = i;
        }
        return ret;
    }
}
