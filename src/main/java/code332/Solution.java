package code332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> areas = new HashMap<>();
        for (List<String> ls : tickets) {
            PriorityQueue<String> integers = areas.computeIfAbsent(ls.get(0), k -> new PriorityQueue<>());
            integers.add(ls.get(1));
        }

        List<String> result = new LinkedList<>();
        dsf(result, "JFK", areas);
        return result;
    }

    private void dsf(List<String> result, String src, Map<String, PriorityQueue<String>> areas) {
        PriorityQueue<String> strings = areas.get(src);
        while (strings != null && strings.size() > 0) {
            dsf(result, strings.poll(), areas);
        }
        result.add(0,src);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> tickets = new ArrayList<>();
        //test1(tickets);

        //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        List<String> itinerary = solution.findItinerary(tickets);
        for (String s : itinerary) {
            System.out.printf(s + "  ");
        }
    }

    private static void test1(List<List<String>> tickets) {
        //["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
    }
}
