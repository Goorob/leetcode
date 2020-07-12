package MarkdownParser;

import java.util.HashMap;

public class MarkdownParser {
    public static void main(String[] args) {
        MarkdownParser parser = new MarkdownParser();
        text("A Bold Text : *text in bold!*");
        text("An Emphasized Text : _emphasized text_");
        text("A code : `function addNum(num1, num2) { return num1 + num2; }`");

        /**
         * A Bold Text : <strong>text in bold!</strong>
         * An Emphasized Text : <em>emphasized text</em>
         * A code : <code>function addNum(num1, num2) { return num1 + num2; }</code>
         */
    }

    private static void text(String text){
        StringBuilder result = new StringBuilder();

        HashMap<String, String> reserved = new HashMap<>();
        reserved.put("_", "<em>_</em>");
        reserved.put("`", "<code>_</code>");
        reserved.put("*", "<strong>_</strong>");

        HashMap<String, Boolean> flags = new HashMap<>();
        flags.put("*", false);
        flags.put("_", false);
        flags.put("`", false);

        for (char s : text.toCharArray()){
            if (!reserved.containsKey(String.valueOf(s)) || Character.isSpaceChar(s) || Character.isAlphabetic(s) || Character.isDigit(s)){
                result.append(s);
            } else {
                String markdown = String.valueOf(s);
                if (!flags.get(markdown)){
                    String tag = reserved.get(markdown).split("_")[0];
                    result.append(tag);
                    flags.replace(markdown, true);
                } else {
                    String tag = reserved.get(markdown).split("_")[1];
                    result.append(tag);
                    flags.replace(markdown, false);
                }
            }
        }
        System.out.println(result.toString());
    }
}
