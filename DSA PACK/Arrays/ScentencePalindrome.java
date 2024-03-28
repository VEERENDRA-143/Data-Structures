public class ScentencePalindrome {
    public static void main(String[] args) {
        String s = "9y";
        isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        String reference = "abcdefghijklmnopqrstuvwxyz0123456789";
        s = s.replace(" ", "").toLowerCase();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (reference.indexOf(s.charAt(i)) >= 0) {
                ans+=s.charAt(i);   
            }
        }
        System.out.println(ans);
        System.out.println(isPalindromeOrNot(ans));
        return isPalindromeOrNot(ans);
    }
    public static boolean isPalindromeOrNot(String s){
        int start =0;
        int end=s.length()-1;
        while (start <= end) {
            if (s.charAt(start)== s.charAt(end)) {
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }

}
