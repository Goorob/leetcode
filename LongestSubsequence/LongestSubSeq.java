package LongestSubsequence;

import java.util.Arrays;

public class LongestSubSeq {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{
                longestSubstring("abcabcbb"),
                longestSubstring("bbbb"),
                longestSubstring("pwwkew"),
                longestSubstring("qwertyqwer")
        }));
    }

    private static String longestSubstring(String s) {
        char current, next;
        char[] char_array = s.toCharArray();

        String result = "";
        result += char_array[0];

        for (int i = 0; i < char_array.length - 1; i++) {
            current = char_array[i];
            next = char_array[i + 1];

            if (current != next && !result.contains(String.valueOf(next)))
                result += next;
        }
        return result;
    }
}
