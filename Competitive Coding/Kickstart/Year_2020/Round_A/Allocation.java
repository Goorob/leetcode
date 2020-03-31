package Kickstart.Year_2020.Round_A;

import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        int[] soln = new int[]{
                noOfHouses(new int[]{20, 90, 40, 90}, 100),
                noOfHouses(new int[]{30, 10, 30, 10}, 50),
                noOfHouses(new int[]{999, 999, 999}, 300)
        };

        int i = 0;
        for (int k : soln)
            System.out.println("Case #" + ++i + ": " + k);

//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int j = 1; j <= t ; j++) {
//
//            String noh_b = sc.nextLine();
//
//            int b = Integer.parseInt(noh_b.split(" ")[1]);
//
//            String array = sc.nextLine();
//            char[] carr = array.toCharArray();
//            int[] houses = new int[carr.length];
//
//            for (int k = 0; k < carr.length; k++) {
//                houses[k] = Integer.parseInt(String.valueOf(carr[j]));
//            }
//            int res = noOfHouses(houses, b);
//            System.out.println("Case #" + j + ": " + res);
//        }
    }

    private static int noOfHouses(int[] houses, int budget) {
        int count = 0;
        int spent = 0;
        for (int i = 0; i < houses.length; i++) {
            if (spent < budget) {
                if (spent + houses[i] <= budget) {
                    spent += houses[i];
                    count++;
                }
            }
        }
        return count;
    }
}
