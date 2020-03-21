package ReverseInteger;

import java.util.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{
                reverseInt(123),
                reverseInt(234),
                reverseInt(-345),
                reverseInt(120)
        }));
    }

    private static int reverseInt(int i) {
        char[] carr = String.valueOf(i).toCharArray();

        int index = (carr[0] == '-') ? 1 : 0;
        int result = 0, part = 1;

        int[] ints = new int[carr.length];

        for (int j = index; j < carr.length; j++) {
            ints[j] = Integer.parseInt(String.valueOf(carr[j]));
            result += ints[j] * part;
            part *= 10;
        }

        return (index == 0) ? result : result * -1;
    }
}
