import java.util.ArrayList;
import java.util.Stack;

public class PrintBracketNumber {
    public static void main(String[] args) {
        String str  = "(((()(";
        bracketNumbers(str);
    }
    public static ArrayList<Integer> bracketNumbers(String str) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int c = 1;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                System.out.println(c);
                ans.add(c);
                stack.push(c);
                c++;
            }
            if (ch == ')') {
                
                // System.out.println(stack.pop());
                ans.add(stack.pop());
                
            }
        }
        System.out.println(ans);
        return ans;
    }
}
