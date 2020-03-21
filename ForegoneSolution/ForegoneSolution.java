package ForegoneSolution;

import java.util.Arrays;

public class ForegoneSolution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{
                getPairs(3),
                getPairs(4),
                getPairs(940),
                getPairs(4444),
                getPairs(2345)
        }));
    }

    private static String getPairs(int n){
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        char[] carr = String.valueOf(n).toCharArray();
        for (char c : carr) {
            if (c == '4') {
                A.append('3');
                B.append('1');
            } else {
                A.append(c);
                B.append('0');
            }
        }
        return Arrays.toString(new int[]{Integer.parseInt(A.toString()), Integer.parseInt(B.toString())});
    }
}
