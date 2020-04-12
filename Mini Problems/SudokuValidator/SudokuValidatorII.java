package SudokuValidator;

/**
 * Sudoku Validator - HashSet Approach O(1) Lookups,
 * @author Dipesh Patil
 * @since 2020-04-11
 * @link https://github.com/dipeshpatil
 */

import java.util.HashSet;

public class SudokuValidatorII {
    public static void main(String[] args) {
        int[][] valid_board = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        int[][] invalid_board = new int[][]{
                {8, 7, 9, 4, 3, 9, 8, 3, 1},
                {1, 8, 5, 3, 6, 1, 9, 7, 4},
                {2, 6, 4, 9, 7, 8, 2, 3, 5},
                {5, 5, 8, 6, 3, 4, 1, 3, 7},
                {4, 3, 7, 1, 9, 4, 6, 5, 8},
                {9, 2, 1, 8, 5, 6, 4, 9, 3},
                {2, 9, 2, 4, 1, 3, 5, 8, 6},
                {3, 4, 3, 5, 2, 6, 7, 1, 9},
                {1, 5, 7, 7, 8, 9, 3, 4, 2}
        };


        System.out.println(isValidSudoku(invalid_board));
    }

    private static boolean isValidSudoku(int[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int current_val = board[i][j];
                if (!seen.add(current_val + " found in row " + i) ||
                        !seen.add(current_val + " found in col " + j) ||
                        !seen.add(current_val + " found in boxes " + i / 3 + "-" + j / 3))
                    return false;
            }
        }
        return true;
    }
}
