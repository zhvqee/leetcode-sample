package code1837;

public class Solution {
    public int sumBase(int n, int k) {
        if (n == 0) {
            return 0;
        }

        int sum = 0;
        while (n != 0) {
            sum += n % k;
            n=n/k;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int sumBase = solution.sumBase(10, 10);
        System.out.println(sumBase);
    }
}
