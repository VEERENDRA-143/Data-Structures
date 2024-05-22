
// https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75

// There is a robot on an m x n grid.
// The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

public class UniquePath {
    public static void main(String[] args) {
        
        int[][] grid = {
            // {0,0,0},
            {0,1},
            {0,0},
        };
        int m = grid.length, n = grid[0].length;
        System.out.println(findMinPath(m, n,grid));
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int findMinPath(int m, int n,int[][] grid) {
        int[][] dp = new int[m][n];
        return helper(dp, m, n, 0, 0,grid);
    }

    // TC -> O(n*2^n)
    private static int helper(int[][] dp, int m, int n, int p1, int p2,int[][] grid) {
        if (p1 + 1 == m && p2 + 1 == n) {
            return 1;
        }
        if (p1 == m)
            return 0;
        if (p2 == n)
            return 0;
        if (dp[p1][p2] != 0) {
            return dp[p1][p2];
        }
        if (grid[p1][p2] != 1) {
            dp[p1][p2] = helper(dp, m, n, p1 + 1, p2,grid) + helper(dp, m, n, p1, p2 + 1,grid);
        }
        return dp[p1][p2];
    }

    // Optimization -> O(n*n) Tabulation
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length, m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1)    dp[i][j]=0;
                else{
                    if(i>0)    dp[i][j]+=dp[i-1][j];
                    if(j>0)    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
