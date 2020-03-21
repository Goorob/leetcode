package YouCanGoYourOwnWay;

import java.util.Arrays;

public class YCGYOW {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{
                constructPath("SE"),
                constructPath("EESSSESE")
        }));
    }

    private static String constructPath(String path){
        char[] carr = path.toCharArray();
        String res = "";
        for (char c : carr){
            if (c == 'S')
                res += 'E';
            else
                res += 'S';
        }
        return res;
    }
}
