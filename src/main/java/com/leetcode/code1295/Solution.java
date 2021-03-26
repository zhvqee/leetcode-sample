package com.leetcode.code1295;

public class Solution {

    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] + "").length() & 1) == 0) {
                cnt++;
            }
        }
        return cnt;

    }
}
