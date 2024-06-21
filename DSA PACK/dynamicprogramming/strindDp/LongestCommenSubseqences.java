
public class LongestCommenSubseqences {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "bdgek";
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        System.out.println(tabulation(s1, s2));
        // System.out.println(longestCommonSubsequence(text1, text2));
        
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        System.out.println(memoize(n-1, m-1, text1, text2, dp));
        return f(n-1,m-1,text1,text2);
    }
    private static int f(int ind1, int ind2, String text1, String text2) {
       
        if ( ind1 < 0 || ind2 < 0 ) {
            return 0;
        }
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + f(ind1-1, ind2-1, text1, text2);
        }

        return Math.max(f(ind1-1, ind2, text1, text2), f(ind1, ind2-1, text1, text2));
    }

    private static int memoize(int ind1,int ind2,String text1,String text2,int[][] dp){
        if (ind1 <0 || ind2 < 0) {
            return 0;
        }
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1+ memoize(ind1-1, ind2-1, text1, text2, dp);
        }
        if (dp[ind1][ind2] != 0) {
            return dp[ind1][ind2];
        }
        return dp[ind1][ind2] = Math.max(memoize(ind1-1, ind2, text1, text2, dp), memoize(ind1, ind2-1, text1, text2, dp));
    }

    private static int tabulation(char[] s1, char[] s2){
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {
                int ans = 0;
                if (s1[i-1] == s2[j-1]) {
                    ans = 1 + dp[i-1][j-1];
                }
                else{
                    ans = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = ans;
            }
        }

        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m ; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
