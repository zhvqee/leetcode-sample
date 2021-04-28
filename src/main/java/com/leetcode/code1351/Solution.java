package com.leetcode.code1351;


public class Solution {

    /**
     * [4,3,2,-1],
     * [3,2,1,-1],
     * [1,1,-1,-2],
     * [-1,-1,-2,-3]
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        int pos = grid[0].length - 1;
        int m = grid[0].length;
        int relPos = pos;
        for (int i = 0; i < grid.length; i++) {

            while (pos >= 0 && grid[i][pos] < 0) {
                relPos = pos;
                pos--;
            }

            if (grid[i][relPos] < 0) {
                cnt += (m - relPos);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int countNegatives = solution.countNegatives(new int[][]{
                {2,1},
                {1,1}
        });
        System.out.println(countNegatives);
    }
}
