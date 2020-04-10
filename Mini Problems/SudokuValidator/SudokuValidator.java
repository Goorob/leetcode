/**
 * Sudoku Validator
 * @Author: Dipesh Patil
 * @Github: https://github.com/dipeshpatil
 */

package SudokuValidator;

public class SudokuValidator {
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

        boolean[] soln = new boolean[]{
                isValidSudoku(valid_board),
                isValidSudoku(invalid_board)
        };

        for (boolean sol : soln)
            System.out.println(sol);

        //  true
        //  false
    }

    private static boolean isValidSudoku(int[][] board) {
        return validateRows(board)
            && validateColumns(board)
            && validateSubBoard(board);
    }

    private static boolean validateRows(int[][] board) {
        for (int i = 0; i < 9; i++)
            if (!containsOnlyOnce(board[i]))
                return false;
        return true;
    }

    private static boolean validateColumns(int[][] board) {
        int[] col = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }
            if (!containsOnlyOnce(col))
                return false;
        }
        return true;
    }

    private static boolean validateSubBoard(int[][] board) {
        int[][] subboard = getSubBoards(board);
        for (int[] box : subboard) {
            if (!containsOnlyOnce(box))
                return false;
        }
        return true;
    }

    private static boolean containsOnlyOnce(int[] strip) {
        int[] contains = new int[9];
        for (int i = 0; i < 9; i++) {
            if (!searchElement(contains, strip[i]) && strip[i] >= 1 && strip[i] <= 9)
                contains[i] = strip[i];
            else
                return false;
        }
        return true;
    }

    private static boolean searchElement(int[] arr, int ele) {
        for (int value : arr)
            if (value == ele)
                return true;
        return false;
    }

    private static int[][] getSubBoards(int[][] board) {
        int[][] subbox = new int[9][9];

        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subbox[0][k++] = board[i][j];
            }
        }

        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                subbox[1][k++] = board[i][j];
            }
        }

        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                subbox[2][k++] = board[i][j];
            }
        }

        for (int i = 3, k = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                subbox[3][k++] = board[i][j];
            }
        }

        for (int i = 3, k = 0; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                subbox[4][k++] = board[i][j];
            }
        }

        for (int i = 3, k = 0; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                subbox[5][k++] = board[i][j];
            }
        }

        for (int i = 6, k = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                subbox[6][k++] = board[i][j];
            }
        }

        for (int i = 6, k = 0; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                subbox[7][k++] = board[i][j];
            }
        }

        for (int i = 6, k = 0; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                subbox[8][k++] = board[i][j];
            }
        }

        return subbox;
    }
}