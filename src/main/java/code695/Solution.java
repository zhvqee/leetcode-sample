package code695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, getArea(grid, i, j));
            }
        }
        return max;
    }

    private int getArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return 1 + getArea(grid, r, c - 1) + getArea(grid, r, c + 1) + getArea(grid, r+1, c) + getArea(grid, r-1, c);
    }
}
