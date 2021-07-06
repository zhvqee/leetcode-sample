package code48;

public class Solution {

    private int row;

    private int col;

    private int source;

    private int target;

    private int curi;

    private int curj;

    private int circle;


    public void rotate(int[][] matrix) {

        row = 0;
        col = matrix[0].length;
        curi = 0;
        curj = 0;
        circle = 0;
        while (circle < col / 2) {
            for (int i = 0; i < col - 1; i++) {
                source = matrix[curi][curj];
                rotateRight(matrix);
                rotateDown(matrix);
                rotateLeft(matrix);
                rotateUp(matrix);
            }
            col--;
            row++;
        }

    }


    void rotateDown(int[][] matrix) {
        target = matrix[curj][col - 1];
        matrix[curj][col - 1] = source;
        source = target;
        // 移动位置
        curi = curj;
        curj = col - 1;
    }


    void rotateLeft(int[][] matrix) {
        target = matrix[curj][col - curi - 1];
        matrix[curj][col - curi - 1] = source;
        source = target;
        // 移动位置
        curi = curj;
        curj = col - curi - 1;
    }


    void rotateUp(int[][] matrix) {
        target = matrix[curj][row];
        matrix[curj][row] = source;
        source = target;

        curi = curj;
        curj = row;
    }

    void rotateRight(int[][] matrix) {
        target = matrix[curj][col - curi + 1];
        matrix[curj][col - curi + 1] = source;
        source = target;

        curi = curj;
        curj = col - curi + 1;
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        Solution solution = new Solution();
        solution.rotate(matrix);
        solution.print(matrix);
    }
}
