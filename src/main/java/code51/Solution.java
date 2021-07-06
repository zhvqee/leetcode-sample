package code51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[][] coordinate = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };

    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        int[] row = new int[n];
        int[] col = new int[n];
        int[] leftIndi = new int[2 * n - 1];
        int[] rightIndi1 = new int[2 * n - 1];
        int[] rightIndi2 = new int[2 * n - 1];


        if (n == 1) {
            List<String> ls = new ArrayList<>();
            ls.add("Q");
            result.add(ls);
            return result;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(row, col, leftIndi, rightIndi1, rightIndi2,
                        arr, i, j, n, n, result);

            }
        }
        return result;
    }

    private List<String> addStr(int[][] arr) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j] == 1 ? 'Q' : '.');
            }
            stringList.add(sb.toString());
        }
        return stringList;

    }


    boolean compare(List<String> l1, List<String> l2) {
        for (int i = 0; i < l1.size(); i++) {
            String s1 = l1.get(i);
            String s2 = l2.get(i);
            if (!s1.equals(s2)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] row, int[] col, int[] leftIndi, int[] rightIndi1, int[] rightIndi2,

                        int[][] arr, int i, int j, int n, int max, List<List<String>> result) {

        if (n == 0) {
            List<String> stringList = addStr(arr);
            if (result.isEmpty()) {
                result.add(stringList);
            } else {
                boolean b = true;
                for (List<String> ss : result) {
                    boolean compare = compare(ss, stringList);
                    if (compare) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    result.add(stringList);
                }
            }

            return true;
        }

        if (row[i] == 1) {
            return false;
        }
        if (col[j] == 1) {
            return false;
        }

        if (leftIndi[i + j] == 1) {
            return false;
        }
        if (j >= i) {
            if (rightIndi1[j - i] == 1) {
                return false;
            }

        } else {
            if (rightIndi2[i - j] == 1) {
                return false;
            }
        }

        row[i] = 1;
        col[j] = 1;
        leftIndi[i + j] = 1;
        if (j >= i) {
            rightIndi1[j - i] = 1;
        } else {
            rightIndi2[i - j] = 1;
        }


        boolean isTrue = false;
        arr[i][j] = 1;
        for (int k = 0; k < coordinate.length; k++) {
            int x = i + coordinate[k][0];
            int y = j + coordinate[k][1];
            if (x >= 0 && y >= 0 && x < max && y < max) {
                boolean dfs = dfs(row, col, leftIndi, rightIndi1, rightIndi2, arr, x, y, n - 1, max, result);
                if (dfs) {
                    isTrue = true;
                    break;
                }
            }
        }
        arr[i][j] = 0;
        row[i] = 0;
        col[j] = 0;
        leftIndi[i + j] = 0;
        if (j >= i) {
            rightIndi1[j - i] = 0;
        } else {
            rightIndi2[i - j] = 0;
        }

        return isTrue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(1);

        for (List<String> ls : lists) {
            for (String s : ls) {
                System.out.println(s);
            }
            System.out.println("=====");
        }
    }

}
