package DynamicProgramming;

import java.util.Arrays;

/**
 * Fractional Knapsack - Greedy Approach
 * Overall Complexity - O(N*N)
 * Algorithm Complexity - O(N)
 */

public class FractionalKnapsack {
    public static void main(String[] args) {
        FKnap(new int[]{18, 5, 9, 10, 12, 17}, new int[]{7, 2, 3, 5, 3, 2}, 13);

        /**
           Item		Profit		Weight		P/W
           1		17		2		8.5
           2		12		3		4.0
           3		9		3		3.0
           4		18		7		2.57
           5		5		2		2.5
           6		10		5		2.0
           Total Profit: 50.86
           Total Weight: 13.0
           Fraction of Items Taken: [1.0, 1.0, 1.0, 0.71, 0.0, 0.0]
         */
    }

    private static void FKnap(int[] profits, int[] weights, int sackCapacity) {
        if (profits.length != weights.length) {
            System.out.println("profits[] and weights[] must be of same size");
            return;
        }

        int N = profits.length; // No of items.
        double CW = 0, CP = 0;
        double[] X = new double[N];
        double[] pbw = new double[N];

        for (int i = 0; i < N; i++)
            pbw[i] = roundOff(((profits[i] * 1.0) / weights[i]));

        int[][] sorted = customSort(profits, weights, sort(pbw));
        // Sort both the arrays according to profits by weights

        profits = sorted[0];
        // Get the new profits sorted according to profits by weights

        weights = sorted[1];
        // Get the new weights sorted according to profits by weights

        System.out.println("Item\tProfit\tWeight\tP/W");

        for (int i = 0; i < N; i++) {
            if (CW + weights[i] < sackCapacity) {
                X[i] = 1;
                CP += profits[i];
                CW += weights[i];
            } else {
                X[i] = ((sackCapacity - CW) * 1.0) / weights[i];
                CP += profits[i] * X[i];
                X[i] = roundOff(X[i]);
                CW = sackCapacity;
            }
            System.out.println(String.format("%s\t\t%s\t\t%s\t\t%s", i + 1, profits[i], weights[i], pbw[i]));
        }

        System.out.println("Total Profit: " + roundOff(CP));
        System.out.println("Total Weight: " + roundOff(CW));
        System.out.println("Fraction of Items Taken: " + Arrays.toString(X));
    }

    // Rounding off to 2 decimal places
    private static double roundOff(double x) {
        return Math.round(x * 100.0) / 100.0;
    }

    // Utility function to sort according to Profits by Weights;
    private static int[][] customSort(int[] profits, int[] weights, double[] pbw) {
        int N = profits.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pbw[i] == roundOff((profits[j] * 1.0) / weights[j])) {
                    swap(i, j, profits);
                    swap(i, j, weights);
                }
            }
        }
        return new int[][]{profits, weights};
    }

    // A utility bubblesort function to sort an array in descending order
    private static double[] sort(double[] arr) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1 - counter; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(i, i + 1, arr);
                    isSorted = false;
                }
            }
            counter++;
        }
        return arr;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int i, int j, double[] arr) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
