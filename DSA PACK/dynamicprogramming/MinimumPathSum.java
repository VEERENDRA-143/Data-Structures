public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1,2,3},
            {4,5,6},
        };
        minPathSum(grid);
    }
    public static void minPathSum(int[][] grid) {
        System.out.println(f(grid.length-1, grid[0].length-1, grid));

        int[][] dp = new int[grid.length][grid[0].length];
        System.out.println(tabulation(grid.length-1, grid[0].length-1, grid, dp));
        // System.out.println(Memoization(grid.length-1, grid[0].length-1, grid,dp));
    }

    public static int f(int row,int col,int[][] grid){
        if (row == 0 && col == 0) {
            
            return grid[row][col];
        }
        if (row <0 || col <0) {
           
            return Integer.MAX_VALUE; 
        }
        
        int up = f(row-1, col, grid);
        int left  = f(row, col-1, grid);
        return grid[row][col] + Math.min(up, left);
    }

    public static int Memoization(int row,int col,int[][] grid,int[][] dp){
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if (row < 0|| col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int up = Memoization(row-1, col, grid, dp);
        int left = Memoization(row, col-1, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(up, left);
    }

    public static int tabulation(int row,int col,int[][] grid,int[][] dp){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i ==0 && j==0) {
                    dp[i][j] = grid[i][j];
                }
                else {
                    int up = grid[i][j] ;
                    int left = grid[i][j] ;
                    if (i>0) {
                        up +=  dp[i-1][j];
                    }
                    if (j>0) {
                        left += dp[i][j-1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[row][col];
    }
    
}
