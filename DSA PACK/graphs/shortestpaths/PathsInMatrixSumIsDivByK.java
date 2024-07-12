public class PathsInMatrixSumIsDivByK {
    public static void main(String[] args) {
        int[][] grid = {
            {7,3,4,9},
            {2,3,6,2},
            {2,3,7,0}
        };
        int k = 1;
        System.out.println(numberOfPaths(grid, k));
    }
    public static int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        return f(0, 0, grid, k, 0,dp);
    }
    public static int f(int row,int col,int[][] grid,int k,int sum,int[][] dp){

        if (row == grid.length - 1 && col == grid[0].length - 1 ) {
            if ((sum + grid[row][col]) % k == 0) {
                return 1;
            }
        }
        
        if (row < 0 || col < 0 || row > grid.length || col > grid[0].length) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if (row < grid.length && col < grid[0].length) {
            sum = sum+grid[row][col];
        }
        int right = f(row, col+1, grid, k,sum,dp);
        int down =  f(row+1, col, grid, k,sum,dp);
        
        return dp[row][col] = right + down;
    }
}
