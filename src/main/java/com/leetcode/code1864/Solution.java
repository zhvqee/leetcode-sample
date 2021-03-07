package com.leetcode.code1864;

/**
 * 1684. 统计一致字符串的数目
 * <p>
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {

        int sum = 0;
        int[] hash = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            hash[allowed.charAt(i) - 97] = 1;
        }
        for (String word : words) {
            sum += countConsistentString(hash, word);
        }
        return sum;
    }

    private int countConsistentString(int[] hash, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (hash[word.charAt(i) - 97] == 0) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int cad = solution.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"});
        System.out.println(cad);
    }


    /***
     *
     * 以一个int 作为allowed 的存储
     * 由于 allowed 字符都是不相同的，那么可以取一个 int 类型整数的后 26 位作为标记，比如如果 allowed = "ac" ，那么可以转为一个数：00....000101 (26位），最低位 1 表示 'a' ，另一个 1 表示 'c' ，这样就可以表示一个字符都不相同的字符串 allowed 了，它具有字符 (char)(0 + 'a') 以及 (char)(2 + 'a') ，将 allowed 对应的数称为 ans 。
     *
     * 那么将 words 里的字符串都这样处理，都会获得一个对应的数 res。
     * 当求得一个字符串 word 中的所有字符都出现于 allowed 时，就相当于 word 所对应的数 res 二进制位为 1 的那些位，在 ans 上这些位也都为 1 。
     * 故，如果需要判断 res 的每一个为 1 的位，是否在 ans 上也为 1 ，只需要 res & ans ，来判断结果是否为 res 。
     * 如果不为 res，则说明 res 上某一个为 1 的位，与 ans 对应位上的 0 所相与为 0 ，其总和将小于 res 而非等于 res。
     *
     * 作者：sonrisa_
     * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/solution/zhuang-tai-ya-suo-wei-yun-suan-by-zheng-xl00a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * class Solution {
     *     public int countConsistentStrings(String allowed, String[] words) {
     *         int ans = solve(allowed);
     *         int total = 0;
     *         for (String word : words) {
     *             int res = solve(word);
     *             if((res & ans) == res){
     *                 total ++;
     *             }
     *         }
     *         return total;
     *     }
     *
     *     public int solve(String s) {
     *         int ans = 0;
     *         for(int i = 0; i < s.length(); i++) {
     *             int x = s.charAt(i) - 'a';
     *             ans |= (1 << x);
     *         }
     *         return ans;
     *     }
     * }
     *
     * 作者：sonrisa_
     * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/solution/zhuang-tai-ya-suo-wei-yun-suan-by-zheng-xl00a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
