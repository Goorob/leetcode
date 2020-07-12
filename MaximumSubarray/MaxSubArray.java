package MaximumSubarray;

import java.util.Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[][] soln = new int[][]{
                maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),
                maxSubArray(new int[]{1, 2, 3, 4, 5})
        };
        for (int[] sol : soln)
            System.out.println(Arrays.toString(sol));

        //  [4, -1, 2, 1]
        //  [1, 2, 3, 4, 5]
    }

    private static int[] maxSubArray(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int left = 0, right = 0, s = 0;
        int[] subarray;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                left = s;
                right = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        subarray = new int[right - left + 1];
        for (int i = left, k = 0; i <= right; i++, k++)
            subarray[k] = a[i];
        return subarray;
    }
}
