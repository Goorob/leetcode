package ValidatePalindrome;

import java.util.Arrays;

public class ValidatePalindrome {
    public static void main(String[] args) {
        boolean[] soln = new boolean[]{
                validatePalindrome("A man, a plan, a canal: Panama"),
                validatePalindrome("Mom"),
                validatePalindrome("Malayalam"),
                validatePalindrome("Dipesh")
        };

        System.out.println(Arrays.toString(soln));

        //  [true, true, true, false]
    }

    private static boolean validatePalindrome(String s) {
        s = s.toLowerCase();
        String filteredString = "", result = "";
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isSpaceChar(s.charAt(i)) && Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i)))
                    filteredString += s.charAt(i);
        }
        for (int i = filteredString.length() - 1; i >= 0; i--) {
            result += filteredString.charAt(i);
        }
        return result.equals(filteredString);
    }
}
