package code1252;

public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }

        int rowNum = 0;
        int colNum = 0;
        for (int i = 0; i < m; i++) {
            if (rows[i] % 2 == 1) {
                rowNum++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] % 2 == 1) {
                colNum++;
            }
        }
        return rowNum*n+colNum*m -2*rowNum*colNum;
    }
}
