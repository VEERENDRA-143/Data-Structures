
public class MinFallingPath {
    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 1, 3 },
                { 6, 5, 4 },
                { 7, 8, 9 }
        };
        
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp =new int[n][n];
        for (int i = 0; i < n; i++) {
            
            min = Math.min(min, f(0, i, matrix,dp));
            
        }
        return min;
    }

    private static int f(int row, int col, int[][] matrix,int[][] dp) {

        int min = Integer.MAX_VALUE;
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (row == matrix.length-1) {
            
            return  matrix[row][col];
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        
        if (row+1 < matrix.length ) {
            min = Math.min(min, matrix[row][col] + f(row + 1, col, matrix,dp));
            if (col+1 < matrix.length) {
                min = Math.min(min, matrix[row][col] +f(row + 1, col+1, matrix,dp));
            }
            if (col -1 >=0) {
                min = Math.min(min, matrix[row][col] +f(row + 1, col - 1, matrix,dp));
            }
        }
     
        return dp[row][col] = min;
        
    }

}
