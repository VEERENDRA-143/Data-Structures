public class LogestPandromicString {
    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if (s.length()==1) {
            return s;
        }
        int max=0;
        int startindex=0;
        int endindex=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean check = checkPalindrom(s.substring(i, j+1));
                if (check) {
                    if (Math.max(max, s.substring(i, j+1).length())>max) {
                        max = Math.max(max, s.substring(i, j+1).length());
                        startindex= i;
                        endindex = j+1;
                    }
                    
                }
            }
        }
        return s.substring(startindex, endindex);
    }
    private static boolean checkPalindrom(String substring) {
       
        int start = 0;
        int end = substring.length()-1;
        while (start<=end) {
            if (substring.charAt(start)==substring.charAt(end)) {
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
