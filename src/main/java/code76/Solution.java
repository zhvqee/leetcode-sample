package code76;

public class Solution {


    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();


        int left = 0, right = 0, begin = 0, end = 0, distance = 0, lastMax = charsS.length + 1;

        int[] tFreq = new int[128];
        int[] sFreq = new int[128];
        for (Character c : charsT) {
            tFreq[c]++;
        }

        while (right < charsS.length) {
            char charS = charsS[right];

            if (tFreq[charS] == 0) {
                right++;
                continue;
            }

            right++;
            sFreq[charS]++;

            if (sFreq[charS] <= tFreq[charS]) {
                distance++;
            }

            while (distance == charsT.length) {
                if (right - left < lastMax) {
                    lastMax = right - left;
                    begin = left;
                    end = right;
                }

                // 移动左标签
                charS = charsS[left];
                if (tFreq[charS] == 0) {
                    left++;
                    continue;
                }


                if (sFreq[charS] <= tFreq[charS]) {
                    distance--;
                }
                sFreq[charS]--;
                left++;
            }
        }

        if (lastMax == charsS.length + 1) {
            return "";
        }
        return s.substring(begin, end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solutionS = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(solutionS);

    }
}
