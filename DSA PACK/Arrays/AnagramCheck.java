public class AnagramCheck {
    public static void main(String[] args) {
        String s="aacc";
        String t="ccac";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            System.out.println(s.indexOf(t.charAt(i)));
            if (s.indexOf(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
