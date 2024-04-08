import java.util.Stack;

public class ValidParathesisString {
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString2(s));
    }
    public static boolean checkValidString(String s) {
        
        int leftParethesis = 0;
        int rightParethesis = 0;
        int star = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftParethesis++;
            }
            if (ch==')') {
                rightParethesis++;
            }
            if (ch == '*') {
                
                star++;
            }
        }

        System.out.println(" ( = "+leftParethesis+"\n ) = "+rightParethesis+"\n * = "+star);
        if (leftParethesis == rightParethesis) {
            return true;
        }

        if (leftParethesis < rightParethesis) {
            int diff = Math.abs(leftParethesis-rightParethesis);
            if (diff <= star) {
                leftParethesis = leftParethesis+diff;
            }
            star -= diff;
        }
        else if (rightParethesis < leftParethesis) {
            int diff = Math.abs(leftParethesis-rightParethesis);
            if (diff <= star) {
                rightParethesis = rightParethesis+diff;
            }
            star -= diff;
        }

        System.out.println(" ( = "+leftParethesis+"\n ) = "+rightParethesis+"\n * = "+star);
        if (leftParethesis == rightParethesis) {
            return true;
        }
        return (star == 0);
    }


    // Approch 2
    public static boolean checkValidString2(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        
        return leftMin == 0;
    }
        
}
