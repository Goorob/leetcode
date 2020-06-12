package RemoveElement;

import java.util.Arrays;

public class RemEle {
    public static void main(String[] args) {
        int[][] soln = new int[][]{
                removeElement(new int[]{1, 2, 3, 2}, 2),
                removeElement(new int[]{1, 5, 4, 5, 6, 3, 4}, 5),
                removeElement(new int[]{1, 5, 4, 5, 3, 3, 3, 2}, 3),
        };

        for (int[] sol : soln){
            System.out.println(Arrays.toString(sol));
        }

        //  [1, 3]
        //  [1, 4, 6, 3, 4]
        //  [1, 5, 4, 5, 2]
    }

    private static int[] removeElement(int[] arr, int ele) {
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

        for (int j = 0; j < anotherArray2.length; j++)
            anotherArray2[j] = anotherArray[j];

        return anotherArray2;
    }
}
