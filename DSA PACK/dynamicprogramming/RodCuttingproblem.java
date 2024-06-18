// https://www.naukri.com/code360/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

import java.util.ArrayList;
import java.util.List;

public class RodCuttingproblem {
    public static void main(String[] args) {
        int price[] = {3 ,5 ,8 ,9, 10, 17, 17 ,20};
        int n = price.length;
        System.out.println(cutRod(price, n));
    }
    public static int cutRod(int price[], int n) {
        int[][] dp =new int[n][n+1];
        System.out.println(memoize(n-1, n, price, dp));
		return f(n-1,n,price);
	}
    private static int f(int ind,int n, int[] price) {
        

        if (ind == 0) {
            return n*price[0];
        }

        int nottake = 0 + f(ind-1,n, price);
        int rodLength = ind+1;
        int take = Integer.MIN_VALUE;
        if (rodLength <= n) {
            take = price[ind] + f(ind,n-rodLength, price);
        }
        return Math.max(nottake, take);
    }
    
    private static int memoize(int ind,int N,int[] price,int[][] dp) {

        if (ind == 0) {
            return N*price[0];
        }
        if (dp[ind][N] != 0) {
            return dp[ind][N];
        }

        int notTake = 0 + memoize(ind-1, N, price,dp);
        int take =  Integer.MIN_VALUE;
        int rodlen = ind+1;
        if (rodlen <= N) {
            take = price[ind] + memoize(ind, N-rodlen, price,dp);
        }
        return dp[ind][N] = Math.max(take, notTake);
    }

}
 