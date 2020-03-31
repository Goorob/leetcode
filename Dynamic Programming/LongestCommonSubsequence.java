package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[] soln = new String[]{
                lcs("AGGTAB", "GXTXAYB"),
                lcs("SDLPCMA", "SPLCMA")
        };

        for(String sol : soln)
            System.out.println(sol);

        //  GTAB 
        //  SPCMA
    }

    private static String lcs(String A, String B) {
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
        int len = L[m][n]; // Length Of LCS
        int temp = len;
        char[] lcs = new char[len + 1];
        StringBuilder res = new StringBuilder();

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                lcs[len - 1] = X[i - 1];
                i--;
                j--;
                len--;
            } else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }
        for (int k = 0; k <= temp; k++) {
            res.append(lcs[k]);
        }
        return res.toString();
    }
}
