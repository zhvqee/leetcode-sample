package code77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dnf(n,1, k, path, result);
        return result;
    }

    private void dnf(int n, int level, int k, Deque<Integer> path, List<List<Integer>> result) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //n - (k - path.size()) + 1
        for (int i = level; i <= n - (k - path.size()) + 1; i++) {

            path.add(i);
            dnf(n,i+1, k, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        for (List<Integer> ls : combine) {
            System.out.println(ls);

        }
    }


}
