// https://leetcode.com/problems/maximum-multiplication-score/description/

import java.util.Arrays;

public class MaxMultipilicationScore {
    public static void main(String[] args) {
        int[] a = {3,2,5,6};
        int[] b = {2,-6,4,-5,-3,2,-7};
        System.out.println(maxScore(a, b));
    }
    public static long maxScore(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        long[][] dp = new long[n][m];
        
        
        for (long[] ls : dp) {
            Arrays.fill(ls,Integer.MIN_VALUE);
        }

        long ans = f(a,b,0,0,dp);

        for (long[] ls : dp) {
            System.out.println(Arrays.toString(ls));
        }
       
        return ans;
    }
    private static long f(int[] a, int[] b, int i, int j,long[][] dp) {

        if (i == a.length) {
            return 0;
        }

        if (j >= b.length) {
            return Integer.MIN_VALUE; 
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        long pick = (long)(a[i]*b[j] + f(a,b,i+1,j+1,dp));
        long notPick = f(a,b,i,j+1,dp);

        return dp[i][j] = Math.max(pick,notPick);
      
    }
}
