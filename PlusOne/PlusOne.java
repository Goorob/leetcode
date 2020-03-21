package PlusOne;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        String[] res = new String[]{
                plusOne(new int[]{1, 2, 3, 4}),
                plusOne(new int[]{9, 9, 9}),
                plusOne(new int[]{2, 3, 7}),
                plusOne(new int[]{9, 9, 9, 3, 4, 9})
        };
        for (String row : res) System.out.println(row);

        // [1, 2, 3, 5]
        // [1, 0, 0, 0]
        // [2, 3, 8]
        // [9, 9, 9, 3, 5, 0]
    }

    private static String plusOne(int[] ints) {
        int number = arrayToInt(ints);
        return intToArray(++number);
    }

    private static int arrayToInt(int[] ints) {
        int part = 1, res = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            res += ints[i] * part;
            part *= 10;
        }
        return res;
    }

    private static String intToArray(int n) {
        String number = String.valueOf(n);
        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return Arrays.toString(arr);
    }
}
