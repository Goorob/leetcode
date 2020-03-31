package ThreeSum;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[][] soln = new int[][]{
                getThreeSum(new int[]{23, 45, -73, 59, 13, 17}, -33),
                getThreeSum(new int[]{5, 7, 1, 2, 8, 4}, 10),
                getThreeSum(new int[]{1, 2, 3, 4}, 10)
        };

        for (int[] sol : soln)
            System.out.println(Arrays.toString(sol));

        //  [23, -73, 17]
        //  [5, 1, 4]
    }

    private static int[] getThreeSum(int[] ints, int a) {
        int N = ints.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (ints[i] + ints[j] + ints[k] == a && i != j && j != k && i != k)
                        return new int[]{ints[i], ints[j], ints[k]};
        return new int[]{0};
    }
}
