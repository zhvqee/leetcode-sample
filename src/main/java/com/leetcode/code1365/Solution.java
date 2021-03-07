package com.leetcode.code1365;

/**
 * 1365. 有多少小于当前数字的数字
 * <p>
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]] += 1;
        }

        //计算i小的数量
        for (int i = 1; i < 101; i++) {

            cnt[i] += cnt[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8});

        for (int s : ints) {
            System.out.println(s);
        }

    }
}
