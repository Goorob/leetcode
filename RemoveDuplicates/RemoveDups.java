package RemoveDuplicates;

import java.util.Arrays;

public class RemoveDups {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{
                removeDuplicates(new int[]{1, 2, 3, 3}),
                removeDuplicates(new int[]{3, 4, 5, 6, 2, 1, 4, 5}),
                removeDuplicates(new int[]{78, 45, 34, 56, 89, 45, 45})
        }));
        // - [3, 8, 6]
    }

    private static int removeDuplicates(int[] ints) {
        if (ints.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < ints.length; j++) {
            if (ints[i] != ints[j]) {
                i++;
                ints[i] = ints[j];
            }
        }
        return i + 1;
    }
}
