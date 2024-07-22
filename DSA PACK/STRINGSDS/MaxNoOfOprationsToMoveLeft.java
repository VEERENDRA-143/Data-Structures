import java.util.Arrays;

public class MaxNoOfOprationsToMoveLeft {
    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }

    public static int maxOperations(String s) {
        int res = 0, ones = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            ones += s.charAt(i) - '0';
            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                res += ones;
            }
        }
        return res;
    }

   
    
}
