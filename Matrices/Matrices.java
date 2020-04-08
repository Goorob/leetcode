package Matrices;

class Matrices {
    Matrices(){}

    int[][] add(int[][] mat1, int[][] mat2, int rows, int cols){
        int[][] res_mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res_mat[i][j] = mat1[i][j] + mat2[i][j];
        return res_mat;
    }

    int[][] sub(int[][] mat1, int[][] mat2, int rows, int cols){
        int[][] res_mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res_mat[i][j] = mat1[i][j] - mat2[i][j];
        return res_mat;
    }

    int[][] mul(int[][] mat1, int[][] mat2, int rows, int cols){
        int[][] res_mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < rows; k++)
                    res_mat[i][j] += mat1[i][k] * mat2[k][j];
        return res_mat;
    }

    int[][] mulbyk(int[][] mat1, int rows, int cols,  int k){
        int[][] res_mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res_mat[i][j] = mat1[i][j] * k;
        return res_mat;
    }

    int[][] identityMat(int size){
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (i == j)
                    identity[i][j] = 1;
        return identity;
    }

    int[][] transpose(int[][] mat1, int row, int col){
        int[][] res_mat = new int[col][row];
        for (int i = 0; i < col; i++)
            for (int j = 0; j < row; j++)
                res_mat[i][j] = mat1[j][i];
        return res_mat;
    }
}
