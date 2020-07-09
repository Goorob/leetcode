package DynamicProgramming;

import java.util.Arrays;

/**
 * Stability : stable
 * Fractional Knapsack - Greedy Approach
 * Algorithm Complexity - O(N)
 */

public class FractionalKnapsack{
    public static class Item{
        int profit, weight;
        double pbw;

        Item(int profit,int weight){
            this.profit = profit;
            this.weight = weight;
            this.pbw = roundOff((profit * 1.0) / weight);
        }
    }

    private static void fKnapsack(Item[] items,int sackCapacity){
        int N = items.length;
        double[] X = new double[N];
        double cW = 0, cP = 0;

        System.out.println("Item\t\tProfit\t\tWeight\t\tP/W");

        for (int i = 0; i < N; i++) {
            Item currentItem = items[i];
            if (cW + currentItem.weight < sackCapacity) {
                X[i] = 1;
                cP += currentItem.profit;
                cW += currentItem.weight;
            } else {
                X[i] = ((sackCapacity - cW) * 1.0) / currentItem.weight;
                X[i] = roundOff(X[i]);
                cP += currentItem.profit * X[i];
                cW = sackCapacity;
            }
            System.out.println(
                    String.format(
                            "%d\t\t\t%d\t\t\t%d\t\t\t%.2f",
                            i + 1,
                            currentItem.profit,
                            currentItem.weight,
                            currentItem.pbw
                    ));
        }

        System.out.println("\nTotal Profit: " + cP);
        System.out.println("Total Weight: " + cW);
        System.out.println("Fraction of Items Taken: " + Arrays.toString(X));
    }

    private static void sortItemsByPbW(Item[] items){
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < items.length - 1 - counter; i++) {
                if (items[i].pbw < items[i + 1].pbw) {
                    swap(i,i + 1,items);
                    isSorted = false;
                }
            }
            counter++;
        }
    }

    private static double roundOff(double x){
        return Math.round(x * 100.0) / 100.0;
    }

    private static void swap(int i,int j,Item[] items){
        Item temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args){
        Item[] items = new Item[]{
                new Item(18,7),
                new Item(5,2),
                new Item(9,3),
                new Item(10,5),
                new Item(12,3),
                new Item(17,2),
        };
        int sackCapacity = 13;

        sortItemsByPbW(items);

        fKnapsack(items,sackCapacity);

        /*
            Item		Profit           	Weight		        P/W
            1			17			2			8.50
            2			12			3			4.00
            3			9			3			3.00
            4			18			7			2.57
            5			5			2			2.50
            6			10			5			2.00

            Total Profit: 50.78
            Total Weight: 13.0
            Fraction of Items Taken: [1.0, 1.0, 1.0, 0.71, 0.0, 0.0]
        */
    }
}