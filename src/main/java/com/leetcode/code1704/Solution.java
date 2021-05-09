package com.leetcode.code1704;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {

        int sn = 0;
        int haflen = (s.length() >> 1);

        Set<Character> iou = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < haflen; i++) {
            char ch1 = s.charAt(i);
            if (iou.contains(ch1)) {
                sn++;
            }
            char ch2 = s.charAt(i + haflen);
            if (iou.contains(ch2)) {
                sn--;
            }
        }

        return sn == 0;
    }

    public static void main(String[] args) {
        String s = "textbook";
        //String s = "book";
        Solution solution = new Solution();
        boolean halvesAreAlike = solution.halvesAreAlike(s);
        System.out.println(halvesAreAlike);
    }
}
