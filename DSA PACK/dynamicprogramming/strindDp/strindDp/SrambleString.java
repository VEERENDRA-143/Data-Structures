
import java.util.*;
public class SrambleString {
    
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "caebd";
        System.out.println(isScramble(s1, s2));
    }
    public static boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){return true;}
        if(s1.length() <= 1){return false;}
        
        int n = s1.length();
        for(int i = 1; i<= n-1; i++)   
        { 
            //IF(CONDITON#1 || CONDITON#2){RETURN TRUE;}
            if( (isScramble(s1.substring(0,i), s2.substring(n-i,n))  && isScramble(s1.substring(i,n), s2.substring(0,n-i)))
                                      ||
                (isScramble(s1.substring(0,i), s2.substring(0,i)) &&  isScramble(s1.substring(i,n), s2.substring(i,n)))
			  )
            {
                return true;
            }
        }
        
        return false;
    }

}