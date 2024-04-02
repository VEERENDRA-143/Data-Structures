public class CountAndSay {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        String digits = "1";
        if (n == 0) {
            return digits;
        }
        int i = 0;
        String res = "";
        while (digits.length() < n) {
            while (i < digits.length()) {
                int countChar = findCount(digits, digits.charAt(i));
                res += countChar;
                res += digits.charAt(i);
                i = i + countChar;
            }
            digits = res;
        }
        return reverse(digits, "");

    }

    private static int findCount(String ans, char charAt) {
        int count = 0;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == charAt) {
                count++;
            }
        }
        return count;
    }

    public  static String  reverse(String str, String nstr) {

        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); // extracts each character
            nstr = ch + nstr; // adds each character in front of the existing string
        }
        
        return nstr;

    }

    private static String giveString(char charAt, int count) {
        String ans = "";
        ans += (charAt + count);
        return ans;
    }
}
