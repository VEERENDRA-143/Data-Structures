// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=matrix-chain-multiplication

import java.util.Arrays;

public class MCMProblem {

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        int N = arr.length;
        System.out.println(matrixMultiplication(N, arr));
        // System.out.println("tabulation = "+tabulation(N, arr));
    }

    public static int matrixMultiplication(int N, int arr[]){
        int[][] dp =new int[N][N];
        System.out.println("memo = "+memo(1, N-1, arr, dp));
        return f(1, N-1, arr);
    }

    public static int f(int i,int j,int[] arr){

        if (i == j) {
            return 0;
        }
        int mini =  Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = arr[i-1] * arr[k] * arr[j] + f(i, k, arr) + f(k+1, j, arr);
            if (steps < mini) {
                mini = steps;
            }
        }
        return mini;
    }

    public static int memo(int i,int j,int[] arr,int[][] dp){
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i-1]*arr[k]*arr[j] + memo(i, k, arr,dp)+memo(k+1, j, arr,dp);
            if (steps < mini) {
                mini = steps;
            }
        }
        return dp[i][j] =  mini;
    }

    public static int tabulation(int N,int[]  arr){
        int[][] dp =new int[N][N];
        for (int i = N-1; i >= 1; i--) {
            for (int j = 1 + 1 ;j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k]+dp[k+1][j];
                    if (steps < mini) {
                        mini = steps;
                    } 
                }
                dp[i][j] = mini;
            }
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[1][N-1];
    }

};