package code88;

import java.util.stream.Stream;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j];
                j--;
            } else {
                nums1[k--] = nums1[i];
                i--;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]
        int[] ints = {1};
        solution.merge(ints, 1, new int[]{}, 0);

       for(int i=0;i<ints.length;i++){
           System.out.println(ints[i]);
       }
    }

}
