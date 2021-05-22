package code680;

public class Solution {

    public boolean isPalindrome(char[] charArray, int l, int r) {
        while (l <= r) {
            if (charArray[l] != charArray[r]) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = charArray.length - 1;
        while (l <= r) {
            if (charArray[l] == charArray[r]) {
                l++;
                r--;
            } else {
                return isPalindrome(charArray, l + 1, r) || isPalindrome(charArray, l, r - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean abc = solution.validPalindrome("abca");
        System.out.println(abc);
    }

}
