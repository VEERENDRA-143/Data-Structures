public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "race a car";
        System.out.println(s1.length());
        System.out.println(ReverseVowelsStr(s));
        System.out.println(ReverseVowelsStr(s1));
    }

    public static String ReverseVowelsStr(String s) {
        if (s.length()==1 || s.length()==0) {
            return s;
        }
        int start = 0;
        int end = s.length()-1;
        String vowels = "aeiouAEIOU";
        while (start <= end) {
            if (vowels.indexOf(s.charAt(start)) == -1) {
                start++;
            }
            else if (vowels.indexOf(s.charAt(end)) == -1) {
                end--;
            }
            // if (vowels.indexOf(s.charAt(start)) >= 0 && vowels.indexOf(s.charAt(end)) >= 0) {
            else{
                s = swap(s, start,end);
                start++;
                end--;
            }
        }

        return s;
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
