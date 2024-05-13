import java.util.Stack;

public class Basiccaliculater extends Solution{
    
    public static void main(String[] args) {
        String s = "3+2";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();

        int num = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (isOperator(c) || i == s.length() - 1) {
                if (operator == '+') st.push(num);
                else if (operator == '-') st.push(-num);
                else if (operator == '*') st.push(st.pop() * num);
                else if (operator == '/') st.push(st.pop() / num);

                num = 0;
                operator = c;
            }
        }

        int ans = 0;

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}