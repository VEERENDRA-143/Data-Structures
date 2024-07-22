public class VowelsGameInString {
    public static void main(String[] args) {
        String s = "leetcoder";
        System.out.println(doesAliceWin(s));
    }
    public static boolean doesAliceWin(String s) {
        String vowels = "aeiou";
        int count= 0;
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) >=0) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }
}
