import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        String s = "abc12";
        clearDigits(s);
    }
    public static void  clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        String ans = "";
        while (!stack.isEmpty() ) {
            ans += stack.pop();
        }
        StringBuilder sb = new StringBuilder(ans);
        System.out.println(sb.reverse().toString());
    }
}
