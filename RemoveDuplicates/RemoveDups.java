package RemoveDuplicates;

import java.util.Arrays;

public class RemoveDups {
    public static void main(String[] args) {
        int[][] soln = new int[][]{
                removeDuplicates(new int[]{1, 2, 3, 3, 0, 0}),
                removeDuplicates(new int[]{3, 4, 5, 6, 2, 1, 4, 5}),
                removeDuplicates(new int[]{78, 45, 34, 56, 89, 45, 45})
        };
        for (int[] sol : soln)
            System.out.println(Arrays.toString(sol));
    }

    private static int[] removeDuplicates(int[] arr){
        int len = arr.length;
        int newlen;
        if (len == 0) return arr;

        int i = 0;
        for (int j = 0; j < len; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        newlen =  i + 1;
        int[] unique = new int[newlen];

        for (int k = 0; k < newlen; k++) {
            if (!doesElementExist(unique, arr[k]))
                unique[k] = arr[k];
        }

        return unique;
    }

    private static boolean doesElementExist(int[] arr, int ele){
        for (int value : arr) {
            if (value == ele)
                return true;
        }
        return false;
    }
}
