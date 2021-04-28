package code804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> hash = new HashSet<>();
        for (String s : words) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                String c = code[s.charAt(i) - 'a'];
                stringBuffer.append(c);
            }
            hash.add(stringBuffer.toString());
        }
        return hash.size();
    }
}
