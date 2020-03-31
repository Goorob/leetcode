package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs("XMASDFOP", "XMDOP"));
    }

    private static int lcs(String A, String B) {
        char[] X = A.toCharArray();
        char[] Y = B.toCharArray();
        int m = X.length;
        int n = Y.length;
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
