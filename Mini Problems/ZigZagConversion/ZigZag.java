package ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    public static void main(String[] args) {
        String[] soln = new String[]{
                zigzag("PAYPALISHIRING", 4),
                zigzag("PAYPAL",3)
        };

        for (String s : soln)
            System.out.println(s);

        //  PINALSIGYAHRPI
        //  PAAPLY
    }

    private static String zigzag(String s, int numRows){
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;

            if (goingDown)
                curRow++;
            else
                curRow--;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
