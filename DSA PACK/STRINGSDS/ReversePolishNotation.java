import java.util.*;
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(tokens);
    }
    public static int evalRPN(String[] tokens) {

        String op = "-+/*";
        Stack<Integer> stack = new Stack<>();
        
        for (String string : tokens) {
            if (op.indexOf(string) == -1) {
                stack.push(Integer.parseInt(string));
            }
            else if (op.indexOf(string) != -1) {
                
                int a = 0;
                int b = 0;
                if (!stack.isEmpty()) {
                    a = stack.pop();
                }
                if (!stack.isEmpty()) {
                    b = stack.pop();
                }
                int ind = op.indexOf(string);
                char ch = op.charAt(ind);
                switch (ch) {
                    case '+':
                        stack.push(b+a);
                        break;
                
                    case '*':
                        stack.push(b*a);
                        break;
                
                    case '/':
                        stack.push(b/a);
                        break;
                
                    case '-':
                        stack.push(b-a);
                        break;
                }
            }
        }
        
        return stack.pop();
    }
}
