package TwoSum;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{1, 2, 3, 4}, 6);
        twoSum(new int[]{3, 4, 6, 2, 8, 5}, 9);
    }

//    private static void twoSum(int[] arr, int target) {
//        HashSet<String> hashSet = new HashSet<>();
//        for (int x : arr) {
//            int y = target - x;
//            if (!hashSet.contains(String.valueOf(y)))
//                hashSet.add(String.valueOf(x));
//            else
//                System.out.println(x + ", " + y);
//        }
//    }

    private static void twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                System.out.println("[" + arr[left] + ", " + arr[right] + "]");
                return;
            } else if (currentSum < target)
                left++;
            else right--;
        }
    }
}
