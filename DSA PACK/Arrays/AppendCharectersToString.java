public class AppendCharectersToString {
    public static void main(String[] args) {
        String s = "z";
        String t = "abcde";
        appendCharacters(s, t);
    }
    public static void appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex != s.length() && tIndex != t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            }
            else{
                sIndex++;
            }
        }
        System.out.println(t.substring(tIndex));
        System.out.println(t.substring(tIndex).length());

    }
}
