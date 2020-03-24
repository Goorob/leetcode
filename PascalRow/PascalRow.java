package PascalRow;

import java.util.Arrays;

public class PascalRow {
    public static void main(String[] args) {
        int[][] soln = new int[][]{
                getPascalRow(2),
                getPascalRow(3),
                getPascalRow(4)
        };

        for(int[] sol : soln)
            System.out.println(Arrays.toString(sol));

        /**
             [1, 2, 1]
             [1, 3, 3, 1]
             [1, 4, 6, 4, 1]
         */
    }

    private static int[] getPascalRow(int n) {
        int[] row = new int[n + 1];
        for (int i = 0; i <= n; i++)
            row[i] = fact(n) / (fact(n - i) * fact(i));
        return row;
    }

    private static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }
}
