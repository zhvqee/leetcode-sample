package code560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        long pre = 0;
        int len = nums.length;
        int count = 0;
        Integer current = 0;
        for (int i = 0; i < len; i++) {
            pre += nums[i];

            if ((current = mp.get(pre - k)) != null) {
                count += current;
            }

            mp.compute(pre, (key, value) -> {
                if (value == null) {
                    value = 0;
                }
                return value + 1;
            });


        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int subarraySum = solution.subarraySum(new int[]{1,-1,-1,0,0,2}, 0);
        System.out.println(subarraySum);
    }
}
