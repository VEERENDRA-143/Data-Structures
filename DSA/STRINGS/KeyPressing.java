//  https://www.hackerrank.com/contests/hack-the-interview-v/challenges/strange-keyboard-1

import java.util.*;

public class KeyPressing {
    public static void main(String[] args) {
        String s = "HE*<LL>O";
        receivedText(s);
    }
    public static void receivedText(String s) {
        String ans = "";
        int ind = 0;
        boolean numbersEnabled = true;
        while (ind < s.length()) {
            if (s.charAt(ind) == '*') {
                
                char[] ar = ans.toCharArray();
                String str = "";
                for (int i = 0; i < ar.length-1; i++) {
                    str += ar[i];
                }
                ans = "";
                ans += str;
                ind++;
            }else if (s.charAt(ind) == '<'){
                int x = ind+1;
                String  t = "";
                while (s.charAt(x) >= 'A' && s.charAt(x) <= 'Z'){
                    if (x < s.length() ) {
                        x++;
                    }else{
                        break;
                    }
                }
                t += s.substring(ind+1, x);
                ans = t + ans;
                ind = x;
            }
            else if (s.charAt(ind) == '>'){
                int x = ind+1;
                String  t = "";
                while (x < s.length() && s.charAt(x) >= 'A' && s.charAt(x) <= 'Z' ) {
                    if ( x < s.length()) {
                        x++;
                    }else{
                        break;
                    }
                    
                }
                t += s.substring(ind+1, x);
                ans = ans+t;
               ind = x;
            }else if ( s.charAt(ind) == '#'){
                numbersEnabled =  !numbersEnabled;
            }else if ( Character.isDigit(s.charAt(ind)) && !numbersEnabled){
                continue;
            }
            else{
                ans += s.charAt(ind);
                ind++;
            }
        }
        System.out.println(ans);
    }
}
