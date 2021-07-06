package code893;

public class Solution {
    public int numSpecialEquivGroups(String[] A) {

        int[] idx = new int[A.length];
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            String source = A[i];
            if (idx[i] == 1) {
                continue;
            }
            idx[i] = 1;
            count++;

            for (int j = i + 1; j < A.length; j++) {
                String s = A[j];
                // 已处理
                if (idx[j] == 1) {
                    continue;
                }
                if (isEqualString(source, s)) {
                    idx[j] = 1;
                }
            }
        }
        return count;
    }

    private boolean isEqualString(String soruce, String target) {
        char[] targetArr = target.toCharArray();
        for (int i = 0; i < targetArr.length; i++) {
            char ch1 = soruce.charAt(i);
            char ch2 = targetArr[i];
            if (ch1 != ch2) {
                boolean meet = false;
                int j = i + 2;
                for (; j < targetArr.length; j += 2) {
                    char ch2p = targetArr[j];
                    if (ch2p == ch1) {
                        targetArr[i] = ch2p;
                        targetArr[j] = ch2;
                        meet = true;
                        break;
                    }
                }
                if (!meet) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numSpecialEquivGroups = solution.numSpecialEquivGroups(new String[]{"couxuxaubw", "zsptcwcghr", "kkntvvhbcc", "nkhtcvvckb", "crcwhspgzt"});
        System.out.println(numSpecialEquivGroups);
    }
}
