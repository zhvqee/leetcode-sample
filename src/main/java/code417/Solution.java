package code417;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        int[][] reachsT = new int[heights.length][heights[0].length];
        int[][] reachsD = new int[heights.length][heights[0].length];

        // 竖着
        for (int i = 0; i < heights[0].length; i++) {
            adverseCurrent(heights, reachsT, 0, i);
            adverseCurrent(heights, reachsD, heights.length - 1, i);
        }

        //横着
        for (int i = 0; i < heights.length; i++) {
            adverseCurrent(heights, reachsT, i, 0);
            adverseCurrent(heights, reachsD, i, heights[0].length - 1);
        }


        for (int i = 0; i < reachsT.length; i++) {
            for (int j = 0; j < reachsT[0].length; j++) {
                if (reachsT[i][j] == 1 && reachsD[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }

            }
        }
        return result;
    }

    private void adverseCurrent(int[][] heights, int[][] reachs, int c, int r) {
        if (c >= 0 && r >= 0 && c < heights.length && r < heights[0].length) {
            if (reachs[c][r] == 1) {
                return;
            }

            reachs[c][r] = 1;
            int x = 0, y = 0;
            // 上
            x = c;
            y = r + 1;
            if (y < heights.length && heights[x][y] >= heights[c][r]) {
                adverseCurrent(heights, reachs, x, y);
            }
            //下
            x = c;
            y = r - 1;
            if (y >= 0 && heights[x][y] >= heights[c][r]) {
                adverseCurrent(heights, reachs, x, y);
            }


            //左
            x = c - 1;
            y = r;
            if (x >= 0 && heights[x][y] >= heights[c][r]) {
                adverseCurrent(heights, reachs, x, y);
            }

            //右
            x = c + 1;
            y = r;
            if (x < heights[0].length && heights[x][y] >= heights[c][r]) {
                adverseCurrent(heights, reachs, x, y);
            }
        }
    }
}
