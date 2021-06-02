package code79;

public class Solution {

    private static int[][] coordinate = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int currentIndex = 0;

        int[][] isUsed = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean dfs = dfs(board, m, n, i, j, word, currentIndex, isUsed);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, int r, int c,
                        String word, int currentIndex, int[][] isUsed) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }

        if (isUsed[r][c] == 1) {
            return false;
        }


        char ch = word.charAt(currentIndex);

        if (board[r][c] != ch) {
            return false;
        }

        if (currentIndex == word.length() - 1) {
            return true;
        }

        isUsed[r][c] = 1;


        boolean isTrue = false;
        for (int i = 0; i < 4; i++) {
            boolean dfs = dfs(board, m, n, r + coordinate[i][0], c + coordinate[i][1], word, currentIndex + 1, isUsed);
            if (dfs) {
                isTrue = true;
                break;
            }
        }
        isUsed[r][c] = 0;
        return isTrue;
    }

    public static void main(String[] args) {
        test5();
    }

    private static void test1() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        boolean exist = solution.exist(board, word);
        System.out.println(exist);

    }

    private static void test2() {
        Solution solution = new Solution();
        char[][] board = {
                {'a'}
        };
        String word = "a";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);

    }

    private static void test3() {
        Solution solution = new Solution();
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";

        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }


    private static void test4() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";

        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//"ABCEFSADEESE"
    private static void test5() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCEFSADEESE";

        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

}
