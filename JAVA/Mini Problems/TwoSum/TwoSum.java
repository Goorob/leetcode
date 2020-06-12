package TwoSum;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{1, 2, 3, 4}, 6);
        twoSum(new int[]{3, 4, 6, 2, 8, 5}, 9);
    }

    // Complexity: Space - O(1), Time - O(n*n)
    private static void twoSum2(int[] arr, int target){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (arr[i] + arr[j] == target && i != j){
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
                    return;
                }
    }

    // Complexity: Space - O(n), Time - O(n)
    private static void twoSum1(int[] arr, int target) {
        HashSet<String> hashSet = new HashSet<>();
        for (int x : arr) {
            int y = target - x;
            if (!hashSet.contains(String.valueOf(y)))
                hashSet.add(String.valueOf(x));
            else
                System.out.println(x + ", " + y);
        }
    }

    // Complexity: Space - O(1), Time - O(n*logn)
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
