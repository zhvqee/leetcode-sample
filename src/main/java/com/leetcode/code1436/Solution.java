package com.leetcode.code1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String destCity(List<List<String>> paths) {
        Map<String, String> traceHashMap = new HashMap<>();
        for (List<String> ls : paths) {
            String start = ls.get(0);
            String end = ls.get(1);
            traceHashMap.put(start, end);
        }
        for (String val : traceHashMap.values()) {
            if (!traceHashMap.containsKey(val)) {
                return val;
            }
        }
        return null;
    }
}
