

public class MinimumLengthOfStrings {
    public static void main(String[] args) {
        String s = "cabaabac";
        System.out.println(minimumLength(s));
    }
    public static int minimumLength(String s) {
        int start=0;
        int end = s.length()-1;
        if (s.charAt(start) != s.charAt(end) ) {
            return s.length();
        }
        if (s.length() == 0) {
            return s.length();
        }

        if (s.length()==2) {
            if (s.charAt(0)==s.charAt(1)) {
                return 0;
            }
            else{
                return s.length();
            }
        }

        char ch = s.charAt(start);
        
        if (start<end) {
            while ( start<=end && ch ==s.charAt(start) ) {
                start++;
            }
            while (start<end && ch == s.charAt(end)) {
                end--;
            }
        }
        
        int len = minimumLength(s.substring(start, end+1));
        return len;
    }
}
