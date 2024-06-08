// https://www.naukri.com/code360/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos


// You have been given an N*M matrix filled with integer numbers, 
// find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.

// From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.

// Down: (row+1,col)
// Down left diagonal: (row+1,col-1)
// Down right diagonal: (row+1, col+1)

import java.util.*;
public class MaxPathSumInMatrix {
    public static void main(String[] args) {
        

        // int[][] matrix = {
        //     {1, 2, 10, 4},
        //     { 100, 3, 2, 1},
        //     { 1, 1, 20, 2},
        //     { 1, 2, 2, 1}
        // };
       

        int[][] matrix = {
            {1 ,2 ,3},
            {9,8,7},
            {4,5,6},
        };
        getMaxPathSum(matrix);

    }
    public static void getMaxPathSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        // Recursive
        for (int i = 0; i < matrix[0].length; i++) {
            max = Math.max(f(0,i,matrix,matrix.length-1),max);
        }
        System.out.println(max);

        
        // Tabulation
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        tabulation(matrix, max, dp);

	}

    // Recursive TC = O(3^n) 

    private static int f(int row, int col, int[][] matrix, int n) {
        
        if (row < 0  || col <0 ) {
            return Integer.MIN_VALUE;
        }
        if (col < 0 || col > n) {
            return Integer.MIN_VALUE;
        }
        if (row == n) {
            return matrix[row][col];
        }
        int down = matrix[row][col] + f(row+1, col, matrix, n);
        int leftDiagonal = matrix[row][col] + f(row+1, col-1, matrix, n);
        int rightDiagonal = matrix[row][col] + f(row+1, col+1, matrix, n);

        return Math.max(down,Math.max(leftDiagonal, rightDiagonal));
    }


    // TC = O(n^2)
    public static void tabulation(int[][] matrix,int n,int[][] dp){
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int up = matrix[i][j] + dp[i-1][j];
                int leftDiagonal = Integer.MIN_VALUE;
                int rightDiagonal = Integer.MIN_VALUE;
                if (j-1 >= 0) {
                    leftDiagonal = matrix[i][j] + dp[i-1][j-1];
                } 
                if(j+1 < matrix[i].length){
                    rightDiagonal = matrix[i][j] + dp[i-1][j+1];
                }
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }
        int max = Integer.MIN_VALUE;
        int k = dp.length-1;
        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(max, dp[k][i]);
        }
        System.out.println(max);
    }


    // Memoization
    private static int fDp(int row, int col, int[][] matrix, int n,int[][] dp) {
        
        if (row < 0  || col <0 ) {
            return Integer.MIN_VALUE;
        }
        if (col < 0 || col > n) {
            return Integer.MIN_VALUE;
        }
        if (dp[row][col]  != 0) {
            return dp[row][col];
        }
        if (row == n) {
            return matrix[row][col];
        }
        int down = matrix[row][col] + fDp(row+1, col, matrix, n,dp);
        int leftDiagonal = matrix[row][col] + fDp(row+1, col-1, matrix, n,dp);
        int rightDiagonal = matrix[row][col] + fDp(row+1, col+1, matrix, n,dp);

        return dp[row][col] = Math.max(down,Math.max(leftDiagonal, rightDiagonal));
    }
}
