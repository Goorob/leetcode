package Matrices;

import java.util.Arrays;

public class TestMatrices {
    public static void main(String[] args) {
        int[][] matrice_1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrice_2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int row = matrice_1.length;
        int col = matrice_1.length;

        Matrices matrix = new Matrices();

        System.out.println("Matrix 1");
        // Adding Mat1 and Mat2
        for (int[] res : matrice_1)
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Matrix 2");
        // Adding Mat1 and Mat2
        for (int[] res : matrice_2)
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Adding Mat1 and Mat2");
        // Adding Mat1 and Mat2
        for (int[] res : matrix.add(matrice_1, matrice_2, row, col))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Subtracting Mat1 and Mat2");
        // Subtracting Mat1 from Mat2
        for (int[] res : matrix.sub(matrice_1, matrice_2, row, col))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Multiplying Mat1 and Mat2");
        // Multiplying Mat1 and Mat2
        for (int[] res : matrix.mul(matrice_1, matrice_2, row, col))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Multiplying Mat1 by 10");
        // Multiplying a matrice by a constant k
        for (int[] res : matrix.mulbyk(matrice_1, row, col, 10))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Identity Matrice");
        // Identity Matrice
        for (int[] res : matrix.identityMat(row))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Transpose of Mat1");
        // Transpose of Mat1
        for (int[] res : matrix.transpose(matrice_1, row, col))
            System.out.println(Arrays.toString(res));
        System.out.println();

        System.out.println("Multiplying Identity Mat of size 3 by 7");
        // Multiplying Identity Mat by a constant k
        int[][] identity = new Matrices().identityMat(3);
        for (int[] res : matrix.mulbyk(identity, row, col, 7))
            System.out.println(Arrays.toString(res));
        System.out.println();
    }
}
