package code149;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        Map<Double, Set<Integer>> cnt = new HashMap<>();

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Double k = null;
                Set<Integer> integers = null;
                if (points[i][0] - points[j][0] == 0) {

                     integers.add(points[i][1]);
                    integers.add(points[j][1]);
                } else {
                    k = (points[i][1] - points[j][1]) / ((points[i][0] - points[j][0]) * 1.0);
                    integers = cnt.computeIfAbsent(k, key -> new HashSet<>());
                    integers.add(j);
                    integers.add(i);
                }

                if (max < integers.size()) {
                    max = integers.size();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        //[[3,3],[1,4],[1,1],[2,1],[2,2]]
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        int maxPointss = solution.maxPoints(new int[][]{
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4},
        });
        System.out.println(maxPointss);
    }
}
