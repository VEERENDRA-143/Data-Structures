public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "    day";
        System.out.println(s);
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        s = s.strip();
        if (s.length()==0) {
            return 0;
        }
        if (s.length()==1) {
            return 1;
        }
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') len++;
            else if (len != 0) break;
        }
        return len;
    }
}
