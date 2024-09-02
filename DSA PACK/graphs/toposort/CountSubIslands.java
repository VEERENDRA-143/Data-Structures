import java.util.Arrays;

public class CountSubIslands {
    public static void main(String[] args) {
        int[][] grid1= {
 
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1},
            };
        int[][] grid2 = {

                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
            };
        countSubIslands(grid1, grid2);
    }
    public static void countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m =grid1[0].length;

        int ans = 0;

        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++) {
                if (grid1[row][col] == 0 && grid2[row][col] == 1) {
                    dfs(grid2, row, col);
                }
            }
        }
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++) {
                if (grid1[row][col] == 1 && grid2[row][col] == 1) {
                    dfs(grid2, row, col);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    
    public static void dfs(int[][] grid,int row,int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);

    }
    
}
