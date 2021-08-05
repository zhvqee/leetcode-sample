package code796;

/**
 * @ProjectName: leetcode-sample
 * @Package: code796
 * @ClassName: Solution
 * @Description: 旋转词
 * @Date: 2021/8/5 2:30 下午
 * @Version: 1.0
 */
public class Solution {

    public boolean isRotating(String s1, String s2) {
        if (s2.length() != s1.length()) {
            return false;
        }
        String dp = s1 + s1;
        return kmp(dp, s2);
    }

    private boolean kmp(String dp, String s2) {
        char[] array = dp.toCharArray();
        char[] subs = s2.toCharArray();

        int[] nexts = getNextArr(subs);

        int i = 0;
        int j = 0;
        while (i < array.length && j < subs.length) {
            if (j == -1 || array[i] == subs[j]) {
                i++;
                j++;
            } else {
                j = nexts[j];
            }
        }
        if (j == subs.length) {
            return true;
        }
        return false;
    }

    /**
     * 以 i 结尾的 字符 最长前缀值
     * A  B  C  D  E  A B C
     *
     * @param subs
     * @return
     */
    private static int[] getNextArr(char[] subs) { // 保证 length>=2
        int[] nexts = new int[subs.length];
        nexts[0] = -1;

        int j = 0, k = -1;
        while (j < subs.length - 1) {
            if (k == -1 || subs[j] == subs[k]) {
                nexts[++j] = ++k;
            } else
                k = nexts[k];
        }
        return nexts;
    }

    public static void main(String[] args) {
        int[] nextArr = getNextArr(new char[]{'A', 'B', 'C', 'D', 'D', 'A', 'B', 'D', 'A', 'B', 'C', 'D', 'E', 'F'});
    }

  /*  public static void main(String[] args) {
        Solution solution = new Solution();
        boolean rotating = solution.isRotating("abbbccabbbd", "bccabbbdaab");
        System.out.println(rotating);

    }*/

}
