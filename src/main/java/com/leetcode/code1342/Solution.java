package com.leetcode.code1342;

/**
 * 1342. 将数字变成 0 的操作次数
 * <p>
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 * <p>
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 * <p>
 * 输入：num = 123
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int numberOfSteps(int num) {
        int cnt = 0;

        while (num != 0) {
            if ((num & 1) == 0) {
                num = (num >> 1);

            } else {
                num--;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(91));
        System.out.println(solution.numberOfSteps2(91));
        System.out.println(solution.numberOfSteps3(91));

    }


    public int numberOfSteps2(int num) {
         int count = Integer.bitCount(num) - 1;
        num |= num >> 1;

        num |= num >> 2;

        num |= num >> 4;

        num |= num >> 8;

        num |= num >> 16;

        return count + Integer.bitCount(num);
    }

    public int numberOfSteps3(int num) {
        // 1 的bit位数
        int numberOfOnes = Integer.bitCount(num);
        // 总bit位数-1（从最高位1bit到最低位）
        int bitCount = 0;
        if (num != 0) {
            if (num >> 16 != 0) {
                bitCount += 16;
                num >>= 16;
            }
            if (num >> 8 != 0) {
                bitCount += 8;
                num >>= 8;
            }
            if (num >> 4 != 0) {
                bitCount += 4;
                num >>= 4;
            }
            if (num >> 2 != 0) {
                bitCount += 2;
                num >>= 2;
            }
            if (num >> 1 != 0) {
                bitCount += 1;
                num >>= 1;
            }
        }
        return bitCount + numberOfOnes;
    }


}

