package com.leetcode.code461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int m = 0;
        while (n != 0) {
            n = n & (n - 1);
            m++;
        }
        return m;
    }

    public static void main(String[] args) {

    }
}
