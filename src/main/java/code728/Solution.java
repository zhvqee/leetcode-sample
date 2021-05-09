package code728;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(int num) {
        int n = num;
        while (n != 0) {
            int y = n % 10;
            if (y == 0) {
                return false;
            }
            if (num % y != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}
