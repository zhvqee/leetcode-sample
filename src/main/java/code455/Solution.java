package code455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int [] g={1,2,3};
        int [] s={1,1};
        int contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
