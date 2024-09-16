// https://codeforces.com/contest/2005/problem/A

import java.util.Scanner;

public class SimplePalidrome {
    
        public static void main(String[] args) {
            
            // Scanner scn = new Scanner(System.in);
            // int t = scn.nextInt();
            // System.out.println("t = " + t);

            // for (int i = 0; i < t; i++) {
            //     String str = scn.next();
            //     int k = str.length();
            //     int ans = f(str,k);
            //     System.out.println(ans);
            // }

            String str = "iae";
            int k = str.length();
            System.out.println(f(str, k));

            
        }

        public static int f(String str,int k){
            int n = (int)Math.pow(2,k);
            
            String[] b = new String[n];
            int ans = 1;
            for(int i = 1 ;i  < n ;i++){
                 b[i] = Integer.toBinaryString(i);
                 int diff  =k -  b[i].length();
                 for(int j = 0; j< diff;j++){
                     b[i] = '0'+b[i];
                 }
                 int ind = 0;
                 String sebSeq = "";
                 
                 for(char ch : b[i].toCharArray()){
                     if(ch == '1'){
                         sebSeq += str.charAt(ind);
                     }
                     ind++;
                 }

                 boolean check = checkPalindrom(sebSeq);
                 if(check){
                     ans++;
                 }
            }
            
            return ans;
        }
        
        public static boolean checkPalindrom(String s){
            if(s.length() ==1) return true;
            char[] c = s.toCharArray();
            int left = 0;
            int right = c.length-1;
            
            while(left < right){
                if(c[left] == c[right]){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }

            return true;
        }
    
}
