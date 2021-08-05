package code218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
   /* public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int[] build : buildings) {
            priorityQueue.add(new int[]{build[0], build[2]});
            priorityQueue.add(new int[]{build[1], build[2]});
        }

        List<List<Integer>> list = new ArrayList<>();

        int left = -1, right = -1, high = -1;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (left == -1 && high == -1) {
                left = poll[0];
                high = poll[1];
                list.add(Arrays.asList(left, high));
            } else {
                if (poll[1] > high) {
                    high = poll[1];
                    list.add(Arrays.asList(poll[0], poll[1]));
                    left=Math.max(left,)
                } else {

                    high = poll[1];
                }

            }
        }

        return list;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        List<List<Integer>> skyline = solution.getSkyline(buildings);

        print(skyline);
    }

    private static void print(List<List<Integer>> skyline) {
        for (List<Integer> ls : skyline) {
            for (Integer s : ls) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }*/
}
