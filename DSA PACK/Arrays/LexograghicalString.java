import java.util.*;
public class LexograghicalString {
    public static void main(String[] args) {
        String s = "aaba*";
        clearStars(s);
    }
    public static void clearStars(String s) {
        String ans = "";
        int starIndex = findStar(s);
        if (starIndex == -2) {
            System.out.println(s);
            return;
        }
        for (int i = starIndex - 1; i >= 0; i--) {
            if ((i - 1) != -1 && s.charAt(i) < s.charAt(i - 1)) {
                System.out.println(s.charAt(i));
            } else {
                ans += s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder(ans);

        System.out.println(sb.reverse().toString());

    }

    public static int findStar(String s) {
        int starIndex = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                return starIndex;
            }
            starIndex++;
        }
        return -1;
    }
}
