package TwoSum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{
                getPairs(parseIntArray("1 2 3 4"), 6),
                getPairs(parseIntArray("2 6 5 1"), 7),
                getPairs(parseIntArray("23 56 1 89"), 90),
                getPairs(parseIntArray("23 45 12 56 78 34 56 23 56"), 79),
                getPairs(parseIntArray("3 4 5 6"), 12),
                getPairs(parseIntArray("15 45 35 25"), 100)
        }));
    }

    private static String getPairs(int[] ints, int target) {

        for (int j = 0; j < ints.length; j++) {
            for (int k = 0; k < ints.length; k++) {
                if (ints[j] + ints[k] == target && j != k) {
                    return Arrays.toString(new int[]{j, k});
                }
            }
        }
        return "Not Found!";
    }

    private static int[] parseIntArray(String array_string) {
        String[] arr = array_string.split(" ");
        int length = arr.length;
        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(arr[i]);
        }
        return ints;
    }
}
