import java.util.Stack;

public class RemoveStars {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s){
        Stack<Character> stack = new Stack<>();
        String ans = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            }
            else{
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

        }
        while (!stack.isEmpty()) {
            
            ans+=(stack.pop());
        }

        String answer="";
        for (int i = ans.length()-1; i >=0;i--) {
            answer+=ans.charAt(i);
        }

        return answer;
    }
}
