// https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// 3D - DP

public class MaxChoclates {
    public static void main(String[] args) {
        int[][]  grid = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5}
        };
        int r = 3;
        int c= 4;
        System.out.println(maximumChocolates(r, c, grid));
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[] del = {-1, 0, 1};
        int[][][] dp = new int[r][c][c];
        System.out.println(Memoization(0, 0, c-1, r, c, grid, dp));
		return f(0,0,c-1,r,c,grid);
	}
    
    private static int f(int i, int j1, int j2,int r,int c,int[][] grid) {
        if ( j1 >= c|| j2 >= c || j1<0||j2<0) {
            return -10000001;
        }
        if (i == r-1) {
            if (j1== j2) {
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int dj = -1; dj <= +1; dj++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value =grid[i][j1];
                }else{
                    value = grid[i][j1] +grid[i][j2];
                }
                value += f(i+1, j1+dj, j2+dj2, r, c, grid);
                maxi = Math.max(maxi, value);
            }
        }

        return  maxi;

    }

    // Memoization
    private static int Memoization(int i, int j1, int j2,int r,int c,int[][] grid,int[][][] dp) {
        if ( j1 >= c|| j2 >= c || j1<0||j2<0) {
            return -1000001;
        }
        if (dp[i][j1][j2] != 0) {
            return dp[i][j1][j2];
        }
        if (i == r-1) {
            if (j1== j2) {
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int dj = -1; dj <= +1; dj++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value =grid[i][j1];
                }else{
                    value = grid[i][j1] +grid[i][j2];
                }
                value += Memoization(i+1, j1+dj, j2+dj2, r, c, grid,dp);
                maxi = Math.max(maxi, value);
            }
        }

        return  dp[i][j1][j2] = maxi;

    }
}
