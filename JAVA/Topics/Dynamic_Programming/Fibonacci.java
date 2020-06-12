import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        long[] soln = new long[]{
                fibo(30),
                fibo(25),
                fibo(29)
        };
        System.out.println(Arrays.toString(soln));
        // [832040, 75025, 514229]
    }

    private static long fibo(int n) {
        long[] lookup = new long[n + 1];
        Arrays.fill(lookup, -1);
        if (lookup[n] == -1) {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fibo(n - 1) + fibo(n - 2);
        }
        return lookup[n];
    }
}
