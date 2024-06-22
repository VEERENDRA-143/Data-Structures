import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";
        System.out.println(tabulation(w1, w2));
        System.out.println(minDistance(w1, w2));
    }
    public static int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int[][] dp =new int[i+1][j+1];
        System.out.println(memo(i-1, j-1, word1, word2, dp));
        return f(i-1,j-1,word1,word2);
    }

    private static int f(int i, int j, String word1, String word2) {
        
        if (i < 0) {
            return j+1;
        }
        if (j < 0) {
            return i+1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return 0+f(i-1, j-1, word1, word2);
        }

        int insert = 1 + f(i-1, j, word1, word2);
        int delete = 1 + f(i, j-1, word1, word2);
        int replace = 1 + f(i-1, j-1, word1, word2);

        return Math.min(insert, Math.min(delete, replace));
    }

    public static int memo(int i,int j,String s1,String s2,int[][] dp){

        if (i < 0) {
            return j+1;
        }
        if ( j <0) {
            return i +1;
        }

        if (dp[i][j]  != 0) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = memo(i-1, j-1, s1, s2, dp);
        }
        
        int insert = 1 + memo(i-1, j, s1, s2, dp);
        int delete = 1 + memo(i, j-1, s1, s2, dp);
        int replace = 1 + memo(i-1, j-1, s1, s2, dp);

        return  dp[i][j] = Math.min(insert, Math.min(delete, replace));

    }

    public static int tabulation(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<= n ;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<=m ;j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }

        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[n][m];
    }
}
