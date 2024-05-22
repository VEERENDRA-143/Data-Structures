import java.util.ArrayList;
import java.util.List;

public class LetterCasePerMutation {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> ans = new ArrayList<>();
        ans = letterCasePermutation(s);
        System.out.println(ans);
    }
    public static List<String> letterCasePermutation(String s){
        List<String> ans = new ArrayList<>();
        String str = "";
        helper(s,0, ans,str);
        return  ans;
    }
    public static void helper(String s,int index, List<String> ans, String str){
        // if index == s.length() add to ans and return it
        if (index == s.length()) {
            ans.add(str);
            return;
        }
        char ch = s.charAt(index);
        // Check if the character is Letter or not, if its true chek if it is UpperCase or not 
        if (Character.isLetter(ch)) { 
            if (Character.isUpperCase(ch)) {

                ch = Character.toLowerCase(ch);
                helper(s, index+1, ans, str+ch);

                // Backtrack and keep it as it is.
                
                ch = Character.toUpperCase(ch);
                helper(s, index+1, ans, str+ch);

            }
            else{
                ch = Character.toUpperCase(ch);
                helper(s, index+1, ans, str+ch);

                // Backtrack and keep it as it is.

                ch = Character.toLowerCase(ch);
                helper(s, index+1, ans, str+ch);
            }
        }
        // If it is not the Character directly add it to the str;
        else{
            helper(s, index+1, ans, str+ch);
        }
    }

}
