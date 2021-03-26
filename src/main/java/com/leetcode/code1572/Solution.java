package com.leetcode.code1572;

public class Solution {

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int lot = 0;
        int rot = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[lot][lot];
            sum += mat[lot][rot];
            lot++;
            rot--;
        }
        if ((mat.length & 1) == 1) {
            int mid = mat.length / 2;
            sum -= mat[mid][mid];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{
                {7, 3, 1, 9},
                {3, 4, 6, 9},
                {6, 9, 6, 6},
                {9, 5, 8, 5}};
        int diagonalSum = solution.diagonalSum(arr);
        System.out.println(diagonalSum);
    }
}
