package PalindromeNumber;

import java.util.Arrays;

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean[] soln = new boolean[]{
                isPalindrome(121),
                isPalindrome(-121),
                isPalindrome(10),
                isPalindrome(454),
                isPalindrome(999),
                isPalindrome(-404),
                isPalindrome(404)
        };
        System.out.println(Arrays.toString(soln));

        // - [true, false, false, true, true, false, true]
    }

    private static boolean isPalindrome(int number) {
        char[] carr = String.valueOf(number).toCharArray();
        if (carr[0] == '-')
            return false;
        int result = 0, part = 1;
        for (char c : carr) {
            result += Integer.parseInt(String.valueOf(c)) * part;
            part *= 10;
        }
        return number == result;
    }
}
