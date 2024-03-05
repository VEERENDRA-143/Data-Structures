import java.util.Stack;

public class MinimumNumberOfInsertionsToMakeValid {
    public static int soluntion(String s){

//        if (s.length()==1){
//            return 1;
//        }
//        int count=0;
//        for (char ch : s.toCharArray()){
//            if (ch == '('){
//                count++;
//            }else {
//                count--;
//            }
//        }
//        return Math.abs(count);

        Stack<Character> stack = new Stack<>();
        for (char ch:s.toCharArray()){
            if (ch==')'){
                if (!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }else {
                stack.push(ch);
            }
        }

        return  stack.size();
    }

    public static void main(String[] args) {
        System.out.println(soluntion("(()"));
    }

}
