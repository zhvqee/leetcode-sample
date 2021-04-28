package com.leetcode.code1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] ret = new char[word1.length() + word2.length()];
        int len = Math.min(word1.length(), word2.length());

        int idx = 0;
        for (int i = 0; i < len; i++) {
            ret[idx++] = word1.charAt(i);
            ret[idx++] = word2.charAt(i);
        }
        for (int i = len; i < word1.length(); i++) {
            ret[idx++] = word1.charAt(i);
        }
        for (int i = len; i < word2.length(); i++) {
            ret[idx++] = word2.charAt(i);
        }
        return new String(ret);
    }
}
