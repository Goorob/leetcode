package SquareRoot;

import java.util.Arrays;

public class SquareRoot {
    public static void main(String[] args) {
        double[] sqrts = new double[]{
                squareRoot(36),
                squareRoot(45),
                squareRoot(8),
                squareRoot(16),
                squareRoot(9)
        };
        System.out.println(Arrays.toString(sqrts));
    }

    private static double squareRoot(int number) {
        double temp;
        double sr = number >> 1;
        do {
            temp = sr;
            sr = (temp + (number / temp)) / 2;
        } while ((temp - sr) != 0);
        return sr;
    }
}
