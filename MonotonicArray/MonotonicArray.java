package MonotonicArray;

import java.util.Arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        boolean[] soln = new boolean[]{
                isMonotonic(new int[]{6, 5, 4, 4}),
                isMonotonic(new int[]{1, 3, 2})
        };
        System.out.println(Arrays.toString(soln));
    }

    private static boolean isMonotonicIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    private static boolean isMonotonicDecreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                return false;
        }
        return true;
    }

    private static boolean isMonotonic(int[] arr) {
        return isMonotonicDecreasing(arr) || isMonotonicIncreasing(arr);
    }
}
