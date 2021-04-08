package code1725;

public class Solution {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int length = rectangles[i][0];
            int width = rectangles[i][1];
            int min = Math.min(length, width);
            if (min > maxLen) {
                count = 1;
                maxLen = min;
            } else if (maxLen == min) {
                count++;
            }
        }
        return count;
    }
}
