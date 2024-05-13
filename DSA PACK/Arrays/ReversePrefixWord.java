public class ReversePrefixWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        reversePrefix(word, ch);
    }
    public static String reversePrefix(String word, char ch) {
        if (word.indexOf(ch) < 0) {
            System.out.println(word);
            return word;
        }
        int charIndex = word.indexOf(ch);
        // char first[]  = word.substring(0, charIndex+1).toCharArray();
        StringBuilder prefix = new StringBuilder(word.substring(0, charIndex+1));
        
        // String last = word.substring(charIndex+1,word.length());
        // int i = 0 ;
        // int j = first.length-1;
        // while (i<j) {
        //     char c = first[i];
        //     first[i] = first[j];
        //     first[j] = c;
        //     i++;
        //     j--;
        // }
        // String s="";
        // for (int j2 = 0; j2 < first.length; j2++) {
        //     s+=first[j2];
        // }
        return prefix.reverse().toString()+word.substring(charIndex+1,word.length());
    }
}
