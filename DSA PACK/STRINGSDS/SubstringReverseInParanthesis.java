import java.util.Stack;

public class SubstringReverseInParanthesis {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses(String s) {
            Stack<Character> stack = new Stack<>();

            String t="";
            for (char ch : s.toCharArray()) {
                String inner = "";
                if (ch == ')') {
                    while (stack.peek()!='(') {
                        inner += stack.pop();
                    }
                    // stack.pop();
                }
                else{
                    stack.push(ch);
                }
                t+=inner;
            }
            
            return t;
    }
}
