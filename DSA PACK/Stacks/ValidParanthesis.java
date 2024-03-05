import java.util.Stack;

public class ValidParanthesis {

    public static boolean isvalid(String s){
        Stack<Character> stack =  new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '(' || ch =='[' || ch=='{' ){
                stack.push(ch);
            }else {
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '(' ){
                        return false;
                    }
                }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
                if (ch == '}'){

                    if (stack.pop() != '{' || stack.isEmpty()){
                        return false;
                    }
                }
            }
        }
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isvalid("()[{]"));
    }
}
