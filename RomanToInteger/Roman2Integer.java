package RomanToInteger;

import java.util.Arrays;

public class Roman2Integer {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{
                romanToInteger("CMXCIX"),
                romanToInteger("CCXXXIV"),
                romanToInteger("CDLVI"),
                romanToInteger("IVXLCDM"),
                romanToInteger("XIX")
        }));
        // [999, 234, 456, 1444, 19]
    }

    private static int romanToInteger(String roman) {
        int result = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            switch (roman.charAt(i)){
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    result += 100 * (result >= 500 ? -1 : 1);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    result += 10 * (result >= 50 ? -1 : 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    result += (result >= 5 ? -1 : 1);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
