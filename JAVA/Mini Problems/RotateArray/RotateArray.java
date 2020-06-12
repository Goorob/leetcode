package RotateArray;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[][] soln = new int[][]{
                rotateArray(arr, 3),
                rotateArray(arr, 4)
        };
        for (int[] sol : soln)
            System.out.println(Arrays.toString(sol));

        //  [5, 6, 7, 1, 2, 3, 4]
        //  [4, 5, 6, 7, 1, 2, 3]
    }
    private static int[] rotateArray(int[] arr, int k) {
        if (k == 0) return arr;
        int length = arr.length;
        int[] rotated = new int[length];
        int rotation_point = length - k;
        int j = 0;
        for (int i = rotation_point; i < length; i++) {
            rotated[j] = arr[i];
            j++;
        }
        for (int i = 0; i < rotation_point; i++) {
            rotated[j] = arr[i];
            j++;
        }
        return rotated;
    }

    private static int[] rotateArrayInPlace(int[] arr, int k) {
        if (k == 0) return arr;
        int length = arr.length;
        int rotation_point = length - k;
        for (int i = rotation_point, j = 0; i < length; i++, j++)
            swap(i, j, arr);
        for (int i = rotation_point - 1, j = i; i < length - 1; i++)
            swap(i, j + 1, arr);
        return arr;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
