
public class LongestPalindromicSubSeq {

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s){
        StringBuilder sb = new StringBuilder(s);
        String reversedStr = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        return f(n-1,n-1,s,reversedStr,dp);
    }

    private static int f(int ind1, int ind2, String s, String reversedStr,int[][] dp) {
        
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != 0) {
            return dp[ind1][ind1];
        }

        if (s.charAt(ind1) == reversedStr.charAt(ind2)) {
            return 1 + f(ind1-1, ind2-1, s, reversedStr,dp);
        }

        return dp[ind1][ind2] = Math.max(f(ind1-1, ind2, s, reversedStr,dp), f(ind1, ind2-1, s, reversedStr,dp) );
    }
    
    
}