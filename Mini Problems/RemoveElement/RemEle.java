package RemoveElement;

import java.util.Arrays;

public class RemEle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{
                removeElement(new int[]{1, 2, 3, 2}, 2, true),
                removeElement(new int[]{1, 5, 4, 5, 6, 3, 4}, 5, true),
                removeElement(new int[]{1, 5, 4, 5, 3, 3, 3, 2}, 3, true)
        }));
        // [[1, 3], [1, 4, 6, 3, 4], [1, 5, 4, 5, 2]]

        System.out.println(Arrays.toString(new int[]{
                removeElement(new int[]{1, 2, 3, 2}, 2),
                removeElement(new int[]{1, 5, 4, 5, 6, 3, 4}, 5),
                removeElement(new int[]{1, 5, 4, 5, 3, 3, 3, 2}, 3)
        }));
        // [2, 5, 5]
    }

    private static String removeElement(int[] arr, int ele, boolean s) {
        int[] anotherArray = new int[arr.length];
        int i = 0;
        for (int x : arr)
            if (x != ele)
                anotherArray[i++] = x;
        int k = 0;
        for (int value : anotherArray) {
            if (value != 0)
                k++;
        }
        int[] anotherArray2 = new int[k];
        for (int j = 0; j < anotherArray2.length; j++) {
            anotherArray2[j] = anotherArray[j];
        }
        return Arrays.toString(anotherArray2);
    }

    private static int removeElement(int[] arr, int ele) {
        int newLength = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != ele)
                newLength++;
        }
        return newLength;
    }
}
