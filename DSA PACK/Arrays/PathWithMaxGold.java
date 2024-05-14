

// https://leetcode.com/problems/path-with-maximum-gold/editorial/?envType=daily-question&envId=2024-05-14

public class PathWithMaxGold {
    private final static int[] DIRECTIONS = new int[] {0,1,0,-1,0};
    
    class Solution {
        int max = 0;
        public int getMaximumGold(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                     if(grid[i][j] != 0) {
                        trackPath(i,j, grid, 0);
                     }
                }
            }
           return max;
        }
    
        private void trackPath(int i, int j, int[][] grid, int sum) {
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
                max = Math.max(max, sum);
                return;
            }
            int val = grid[i][j];
            sum += val; 
            grid[i][j] = 0;
            trackPath(i + 1, j, grid, sum);
            trackPath(i - 1, j, grid, sum);
            trackPath(i, j + 1, grid, sum);
            trackPath(i, j - 1, grid, sum);
            grid[i][j] = val;
    
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,6,0},
            {5,8,7},
            {0,9,0},
        };
        System.out.println(getMaximumGold(grid));
    }
    
    public static int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        for(int row =0;row < rows;row++){
            for(int col = 0;col < cols ;col++){
                maxGold = Math.max(maxGold,dfsBacktrack(grid,rows,cols,row,col));
            }
        }
        return maxGold;
    }
    private static int dfsBacktrack(int[][] grid,int rows,int cols,int row,int col){
        if(row<0 || col <0 || row == rows || col == cols || grid[row][col] == 0){
            return 0;
        }
        int maxGold = 0;
        int originalVal = grid[row][col];
        grid[row][col] = 0;
        for(int direction=0;direction<4;direction++){
            maxGold = Math.max(maxGold,dfsBacktrack(grid,rows,cols,DIRECTIONS[direction]+row,DIRECTIONS[direction+1]+col));

        }
        grid[row][col] = originalVal;
        return maxGold+originalVal;
    }
}