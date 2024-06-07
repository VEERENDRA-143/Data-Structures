import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        // dictionary.add("pineapple");

        String sentence = "aadsfasf absbs bbab cadsfafs";

        replaceWords(dictionary, sentence);
    }

    public static void replaceWords(List<String> dictionary, String sentence) {
        String ans = "";
        String[] words = sentence.split(" ");
        for (String string : words) {
            boolean check = false;
            for (int i = 0; i < string.length(); i++) {
                // System.out.println(sentence.substring(0, i + 1));
                String str = string.substring(0, i + 1);
                if (dictionary.contains(str)) {

                    // string = string.substring(0, i + 1);
                    ans += str+" ";
                    // System.out.println(string);
                    check = true;
                    break;

                }
            }
            if (!check) {
                ans += string+" ";
                System.out.println(string);
            }
        }
        System.out.println(ans.substring(0,ans.length()-1));
    }
}
 