
import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        compress(chars);
    }
    
    public static int compress(char[] chars) {
        if (chars.length==1) {
            return chars.length;
        }
        int count=1;
        String s="";
        s += chars[0];
        char currentChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]==currentChar ) {
                count++;
            }
            
            else{
                if (count!=1) {
                    s+=count; 
                }
                s+=chars[i];
                count=1;
                currentChar = chars[i];
            }
        }
        if (count>1) {
            s+=count;
        }
        System.out.println(s);
        // chars =  new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return s.length();
    }
}
