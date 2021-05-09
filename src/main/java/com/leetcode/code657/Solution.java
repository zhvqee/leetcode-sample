package com.leetcode.code657;

public class Solution {
    public boolean judgeCircle(String moves) {

        int rL = 0;
        int uD = 0;
        for (int i = 0; i < moves.length(); i++) {
            char charAt = moves.charAt(i);
            if (charAt == 'R') {
                rL++;
            } else if (charAt == 'L') {
                rL--;
            } else if (charAt == 'U') {
                uD++;
            } else if (charAt == 'D') {
                uD--;
            }
        }
        return rL==0 && uD==0;
    }
}
