package LongestSubsequence;

import java.util.Arrays;
import java.util.Collections;

public class LongestSubSeq {
    public static void main(String[] args) {
        String[] soln = new String[]{
                longestSubstring("abcabcbb"),
                longestSubstring("bbbb"),
                longestSubstring("pwwkew"),
                longestSubstring("qwertyqwer")
        };
        System.out.println(Arrays.toString(soln));
        // [abc, b, pwke, qwerty]

//        System.out.println(longestSubSeq(new int[]{1, 2, 0, 4, 5}));


    }

    private static String longestSubstring(String s) {
        int N = s.length();
        String longestSubString = "";

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) > s.charAt(j)){
                    longestSubString += s.charAt(i);
                }
            }
        }
        return longestSubString;
    }

    private static int longestSubSeq(int[] ints) {
        int N = ints.length;
        Integer[] lis = new Integer[N];
        Arrays.fill(lis, 1);

        for (int i = 1; i < N; i++)
            for (int j = 0; j < i; j++)
                if (ints[i] > ints[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        return Collections.max(Arrays.asList(lis));
    }
}
