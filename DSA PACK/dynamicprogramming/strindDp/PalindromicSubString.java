public class PalindromicSubString {
    public static void main(String[] args) {
        String s = "abc";
        countSubstrings(s);
    }
    public static void countSubstrings(String s) {
        
        int c =0;
        for (int i = 0; i <= s.length()-1; i++) {
            for (int j = i; j <= s.length()-1; j++) {
                boolean check = isPalindom(s.substring(i, j));
                if (check) {
                    c++;
                }
            }
        }
        System.out.println(c);
       
    }
    private static boolean isPalindom( String s) {
        StringBuilder sb = new StringBuilder(s);
        String st = sb.reverse().toString();
        return s.equals(st);
    }
}
