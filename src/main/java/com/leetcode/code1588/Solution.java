package com.leetcode.code1588;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 */
public class Solution {

    /**
     * 统计每个arr[i]在子序列出现的次数
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            sum += (((i + 1) / 2) * ((n - i) / 2) + (i + 1 - (i + 1) / 2) * (n - i - (n - i) / 2)) * arr[i];
        }
        return sum;
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        int[][] f = new int[arr.length][arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            f[i][i] = arr[i];
            sum += arr[i];
        }
        int t = 2;
        while (t < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (i + t < arr.length) {
                    f[i][i + t] = f[i][i + t - 2] + sum(arr, i + t - 1, i + t);
                    sum += f[i][i + t];
                } else {
                    break;
                }
            }
            t += 2;
        }
        return sum;
    }

    int sum(int[] arr, int i, int j) {
        int sum = 0;
        for (int n = i; n <= j; n++) {
            sum += arr[n];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sumOddLengthSubarrays = solution.sumOddLengthSubarrays(new int[]{10, 11, 12});
        System.out.println(sumOddLengthSubarrays);

        sumOddLengthSubarrays = solution.sumOddLengthSubarrays2(new int[]{10, 11, 12});
        System.out.println(sumOddLengthSubarrays);
    }
}
