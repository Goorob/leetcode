package PascalsTriangle;

import java.util.Arrays;

public class PascalsTriangle {
    public static void main(String[] args) {
        int[][][] soln = new int[][][]{
                pascalsTriangle(3),
                pascalsTriangle(4)
        };
        for (int[][] sol : soln){
            System.out.println("------ Length: " + (sol.length - 1) + " -------");
            for(int[] sol1 : sol)
                System.out.println(Arrays.toString(trimArray(sol1)));
            System.out.println();
        }
        /** ------ Length: 3 -------
            [1]
            [1, 1]
            [1, 2, 1]
            [1, 3, 3, 1]

            ------ Length: 4 -------
            [1]
            [1, 1]
            [1, 2, 1]
            [1, 3, 3, 1]
            [1, 4, 6, 4, 1]
         */
    }

    private static int[][] pascalsTriangle(int rows) {
        int[][] triangle = new int[rows + 1][rows + 1];
        for (int i = 0; i < rows + 1; i++)
            for (int j = 0; j <= i; j++)
                triangle[i][j] = fact(i) / (fact(i - j) * fact(j));
        return triangle;
    }

    private static int fact(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n * fact(n - 1);
    }

    private static int[] trimArray(int[] arr){
        int count = 0;
        for (int value : arr)
            if (value != 0)
                count++;
        int[] trimmedArray = new int[count];
        for (int i = 0; i < count; i++) {
            trimmedArray[i] = arr[i];
        }
        return trimmedArray;
    }
    /**
     * trimArray() is an Optional Function
     * Since JAVA arrays are needed to be initialized with a fixed size,
     * There will be a 0 appended where no value is assigned. Hence we
     * are trimming the array and limiting it to only non-zero elements.
     */
}
