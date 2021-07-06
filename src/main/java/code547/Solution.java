package code547;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int[] isVisited = new int[isConnected.length];

        int cnt = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isVisited[i] == 0) {
                connected(isConnected, isVisited, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void connected(int[][] isConnected, int[] isVisited, int i) {
        if (i >= isConnected.length || isVisited[i] == 1) {
            return;
        }
        isVisited[i] = 1;
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[i][k] == 1 && isVisited[k] != 1) {
                connected(isConnected, isVisited, k);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] num = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int circleNum = solution.findCircleNum(num);
        System.out.println(circleNum);
    }
}
