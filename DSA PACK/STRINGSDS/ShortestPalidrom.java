// https://leetcode.com/problems/shortest-palindrome/description/

public class ShortestPalidrom {
    public static void main(String[] args) {
        String  s = "ababbbabbaba";
        shortestPalindrome(s);
    }

    public static void shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        String reverse = rev(s);
        System.out.println(s + " " + reverse);
        System.out.println(reverse.indexOf("aacecaaa"));
        int index = intersection(s,reverse);
        String fontior = s.substring(index, n);
        System.out.println(rev(fontior)+s);
    }
    public static int intersection(String s,String rev){
        int n = s.length();
        for(int i = 0; i < n; i++){
            String str = s.substring(0,i+1);
            if (rev.indexOf(str) < 0) {
                return i;
            }
        }
        return -1; 
    }

    public static String rev(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
