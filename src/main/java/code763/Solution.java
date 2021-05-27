package code763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] sIndex = new int[26];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            sIndex[charArray[i] - 'a'] = i;
        }

        List<Integer> cntList = new ArrayList<>();

        int maxEnd = -1;
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            maxEnd= Math.max(sIndex[ch - 'a'], maxEnd);
            if ( maxEnd > i) {
                cnt++;
            }
            if (maxEnd == i) {
                cntList.add(cnt + 1);
                cnt = 0;
                maxEnd = -1;
            }
        }

        return cntList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.partitionLabels("eaaaabaaec");
        System.out.println(list);
    }
}
