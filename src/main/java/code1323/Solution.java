package code1323;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maximum69Number(int num) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        int p = 0;
        while (num != 0) {
            int n = num % 10;
            if (n == 6) {
                idx = p;
            }
            list.add(n);
            num = num / 10;
            p++;
        }
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int k = list.get(i);
            if (i == idx) {
                k = 9;
            }
            sum = sum * 10 + k;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int maximum69Number = solution.maximum69Number(9669);
        System.out.println(maximum69Number);
    }
}
