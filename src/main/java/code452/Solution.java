package code452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int cnt = 1;
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                right = points[i][1];
                cnt++;
            }

        }
        return cnt;
    }


    public int findMinArrowShots0(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int x = points[0][0];
        int y = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (x <= points[i][0] && points[i][0] <= y) {
                x = Math.max(x, points[i][0]);
                y = Math.min(y, points[i][1]);
            } else {
                x = points[i][0];
                y = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minArrowShots = solution.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
        System.out.println(minArrowShots);
    }
}
