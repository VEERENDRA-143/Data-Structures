public class StringCompressionIII {
    public static void main(String[] args) {
        String word = "abcde";
        compressedString(word);
    }

    public static void compressedString(String word) {
        String comp = "";
        while (!word.isEmpty()) {
            int start = 0;
            int end = 0;
            int count= 0;
            String s = "";
            while (end < word.length()) {
                if (count < 9  && word.charAt(start) == word.charAt(end)) {
                    s+=word.charAt(end);
                    count++;
                    end++;
                } else {
                    break;
                }
            }
            comp+=s.length();
            comp += (s.charAt(start));
            word = word.substring(end);
            // String prefix = findPrefix(word);
            // comp += prefix;
        }
        System.out.println(comp);
    }

    private static String findPrefix(String word) {
        int start = 0;
        int end = 0;
        while (end != word.length()) {
            if (word.charAt(start) == word.charAt(end)) {
                end++;
            } else {
                return word.substring(start, end);
            }
        }
        return "";
    }
}
