package code1528;

public class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            chs[indices[i]] = ch;
        }
        return new String(chs);
    }
}
