package code254;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        char[] charArray = s.toCharArray();
        String min = "";
        for (String target : dictionary) {
            boolean canChange = canChange(charArray, target);
            if (canChange) {
                if (min.equals("") || (min.length() <= target.length())) {
                    if (min.length() == target.length() && min.compareTo(target) <= 0) {
                        continue;
                    }
                    min = target;
                }
            }
        }
        return min;
    }

    private boolean canChange(char[] charArray, String target) {
        int length = target.length();
        int sLen = charArray.length;
        if (sLen < length) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < sLen && j < length; i++) {
            char c = target.charAt(j);
            if (charArray[i] == c) {
                j++;
            }
        }
        return j == length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abpcplea";
        List<String> stringList = Arrays.asList("a","b","c");
        //s = "abpcplea", d = ["ale","apple","monkey","plea"]
        String longestWord = solution.findLongestWord(s, stringList);
        System.out.println(longestWord);
    }

}
