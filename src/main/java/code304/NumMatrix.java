package code304;

public class NumMatrix {


    private int[][] _sum;

    public NumMatrix(int[][] matrix) {
        _sum = new int[matrix.length + 1][matrix[0].length + 1];
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                _sum[i][j] = _sum[i - 1][j] + _sum[i][j - 1] - _sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return _sum[row2 + 1][col2 + 1] - _sum[row2 + 1][col1] - _sum[row1][col2 + 1] + _sum[row1][col1];
    }
}
