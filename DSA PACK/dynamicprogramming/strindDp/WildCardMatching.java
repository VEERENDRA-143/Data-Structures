import java.util.*;


public class WildCardMatching {
    public static void main(String[] args) {
        String s = "m??*ss*?i*pi";
        String p = "mississippi";
        System.out.println(isMatch(s, p));
    }
    public static boolean isMatch(String s, String p) {
        
        int i = s.length();
        int j = p.length();
        int[][] dp = new int[s.length()][p.length()];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        return f(i-1,j-1,s,p,dp);
    }
    
    private static boolean f(int i, int j, String s, String p,int[][] dp) {
        
        if (i <0 && j < 0) {
            return true;
        }

        if ( i< 0 && j>=0) {
            return false;
        }
        if (i>=0 && j<0) {
            for (int k = 0; k < i; k++) {
                if (s.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') {
            return res = f(i-1, j-1, s, p,dp);
        }
        if(s.charAt(i) == '*'){
            return res =  f(i-1, j, s, p,dp) || f(i, j-1, s, p,dp);
        }
        dp[i][j] = res ? 1:0;
        return res;
    }
}


