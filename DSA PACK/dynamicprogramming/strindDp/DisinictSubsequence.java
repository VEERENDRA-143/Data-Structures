public class DisinictSubsequence {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        numDistinct(s, t);
        System.out.println(tabulation(s, t));
        
    }
    public static void numDistinct(String s, String t) {
        int ind1 = s.length()-1;
        int ind2 = t.length()-1;
        int[][] dp = new int[ind1+1][ind2+1];
        System.out.println(memo(ind1, ind2, s, t, dp));
        for (int[] is : dp) {
            for (int ele : is) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        System.out.println(f(ind1, ind2, s, t));
    }
    public static int f(int ind1,int ind2,String s, String t){
        
        if (ind2 < 0) {
            return 1;
        }

        if (ind1 < 0) {
            return 0;
        }

        if (s.charAt(ind1) == t.charAt(ind2)) {
            return f(ind1-1, ind2-1, s, t)+f(ind1-1, ind2, s, t);
        }

        return f(ind1-1, ind2, s, t);

    }

    public static int memo(int ind1,int ind2,String s,String t,int[][]  dp){
        if (ind2 < 0) {
            return 1;
        }
        if (ind1 < 0) {
            return 0;
        }
        
        if (dp[ind1][ind2] !=0 ) {
            return dp[ind1][ind2];
        }
        if (s.charAt(ind1) == t.charAt(ind2)) {
            return dp[ind1][ind2] =  memo(ind1-1, ind2-1, s, t, dp)+memo(ind1-1, ind2, s, t, dp);
        }
        return dp[ind1][ind2] =  memo(ind1-1, ind2, s, t, dp);

    }

    public static int tabulation(String s,String t){
        int ind1 = s.length();
        int ind2 = t.length();

        int[][] dp =new int[ind1+1][ind2+1];
        for (int i = 0; i < ind1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= ind1;i++){
            for(int j = 1;j <= ind2;j++){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        for (int[] is : dp) {
            for (int ele : is) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        return dp[ind1][ind2];
    }
    
}
