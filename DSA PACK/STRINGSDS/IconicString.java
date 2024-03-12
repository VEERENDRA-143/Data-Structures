import java.util.Stack;

public class IconicString {
    public static void main(String[] args) {
        // System.out.println(checkIconic("abcabc"));
        // System.out.println(checkIconic("abccba"));
        // System.out.println(checkIconic("abcdcba"));
        // System.out.println(checkIconic("123321"));
        // System.out.println(checkIconic("13aa31"));
        // System.out.println(checkIconic("AaAa"));
        // System.out.println(checkIconic("$#a#$"));
        System.out.println(usingStack("[{()}]"));
        // method("aa");
    }

    public static void method(String str){
        if (str.substring(0, str.length()/2) == str.substring(str.length()/2, str.length()-1)) {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

    public static boolean checkIconic(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return Math.abs(i - j) == 1 ? true : false;
    }

    public static boolean usingStack(String str){

        Stack<Character> stack = new Stack<>();

        System.out.println(str.length());

        int size = str.length()/2;

        for (int i = 0; i < size; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = size; i < str.length(); i++) {

            if (!stack.isEmpty() && str.charAt(i) == stack.peek() ) {
                System.out.println(stack.pop());
            }
            else{
                stack.push(str.charAt(i));
            }
        }
       return stack.isEmpty();
    }
}
