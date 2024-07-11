import java.util.*;
public class crawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/","../","../","../"};
        System.out.println(minOperations(logs));
    }
    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        
        for (String string : logs) {
            if (string.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (string.equals("./")) {
                continue;
            }else{
                stack.push(string);
            }
        }
        return stack.size();
    }
}
