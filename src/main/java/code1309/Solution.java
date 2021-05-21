package code1309;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String freqAlphabets(String s) {
        Map<String, String> map = new HashMap<>();
        char base = 'a';
        for (int i = 1; i <= 9; i++) {
            map.put(i + "", (char) (base + (i - 1)) + "");
        }
        for (int i = 10; i <= 26; i++) {
            map.put(i + "#", (char) (base + (i - 1)) + "");
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                String substring = s.substring(i, i + 3);
                buffer.append(map.get(substring));
                i += 3;
            }else{
                String substring = s.substring(i, i + 1);
                buffer.append(map.get(substring));
                i++;
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        String freqAlphabets = solution.freqAlphabets("10#11#12");
        System.out.println(freqAlphabets);
    }
}
