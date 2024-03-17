import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        decodeString(s);
    }

    public static void decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String digits = "1234567890";
        String ans = "";
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || digits.indexOf(s.charAt(i)) >= 0) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']') {

                System.out.println(stack.pop());
                int frequency = stack.pop() - 48;
                System.out.println("frequency = "+ frequency);

                for (int j = 0; j < frequency; j++) {
                ans +=subString;
                }
                subString="";
                System.out.println(frequency);

                System.out.println(stack.peek());

                while (stack.peek() != '[') {
                    System.out.println(stack.pop());
                }
            } else {
                // subString+=s.charAt(i);
                stack.push(s.charAt(i));
            }
        }
        ans += subString;
        System.out.println(subString);
        System.out.println(ans);
    }

}



// Stack<Character> stack = new Stack<>();
// Stack<Integer> instack = new Stack<>();
// String digits = "1234567890";
// // String ans = "";

// for (int i = 0; i < s.length(); i++) {

//     if (s.charAt(i) != ']' ) {  
//         stack.push(s.charAt(i));
//     }
//     else{
//         StringBuilder sb = new StringBuilder();
//         while (stack.peek() != '[') {

//             // System.out.println(stack.pop());
//             sb.append(stack.pop());
            
//             // System.out.println(stack.peek());
            
//         }
//         if (stack.peek()=='[' && !stack.isEmpty()) {
//             stack.pop();
//         }
        
//         System.out.println("sb = "+sb);
//         System.out.println(stack.peek());
//         // if (stack.peek()=='[' && !stack.isEmpty()) {
//         //     stack.pop();
//         //     char ch = stack.peek();
//         //     System.out.println(ch);
//         // }
        
//     }

// }