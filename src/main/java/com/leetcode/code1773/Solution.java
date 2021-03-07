package com.leetcode.code1773;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1773. 统计匹配检索规则的物品数量
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * <p>
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * <p>
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * <p>
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * 示例 2：
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-items-matching-a-rule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    static Map<String, Integer> indexMap = new HashMap<>();

    static {
        indexMap.put("type", 0);
        indexMap.put("color", 1);
        indexMap.put("name", 2);

    }


    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = indexMap.get(ruleKey);
        int sum = 0;
        for (List<String> ls : items) {
            if (ls.get(idx).equals(ruleValue)) {
                sum++;
            }
        }
        return sum;

    }


    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> cot1 = Arrays.asList("phone", "blue", "pixel");
        List<String> cot2 = Arrays.asList("computer", "silver", "lenovo");
        List<String> cot3 = Arrays.asList("phone", "gold", "iphone");
        items.add(cot1);
        items.add(cot2);
        items.add(cot3);

        Solution solution = new Solution();
        int countMatches = solution.countMatches(items, "type", "phone");
        System.out.println(countMatches);
    }
}
