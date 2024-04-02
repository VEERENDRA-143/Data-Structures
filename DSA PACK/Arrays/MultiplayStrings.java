import java.util.Stack;

public class MultiplayStrings {
    public static void main(String[] args) {
        String num1 = "123427484895734897598";
        String num2="456470950934509";
       System.out.println( multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
       
        int n1 = convertToInt(num1);
        int n2 = convertToInt(num2);

        return String.valueOf((long)n1*(long)n2);
    }

    public static int convertToInt(String n){
        Stack<Integer> numStack1 = new Stack<>();
        int i = n.length()-1;
        while (i!=-1) {
            numStack1.push((int)n.charAt(i)-'0');
            i--;
        }
        int digit=0;
        while (!numStack1.isEmpty()) {
            digit = digit*10+numStack1.pop();
        }
        return digit;
    }
}
