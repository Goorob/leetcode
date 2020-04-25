package NQueensProblem;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int[][] board_8x8 = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] board_4x4 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][][] soln = new int[][][]{
                solveNQueens(board_8x8),
                solveNQueens(board_4x4)
        };

        for (int[][] sol : soln){
            for (int[] s : sol)
                System.out.println(Arrays.toString(s));
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;

        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static boolean solveNQueenUtil(int[][] board, int col) {
        int N = board.length;
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueenUtil(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static int[][] solveNQueens(int[][] board) {
        solveNQueenUtil(board, 0);
        return board;
    }
}
