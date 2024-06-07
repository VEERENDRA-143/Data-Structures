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
    
}
