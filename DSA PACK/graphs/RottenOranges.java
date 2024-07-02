public class RottenOranges {
    int[][] grid;

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        this.grid = grid;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    dfs(row,col,2);
                }
            }
        }

        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes;
    }

    private void dfs(int row, int col,int min) {

        if (row < 0 || col < 0|| 
            row >= grid.length || col >= grid[0].length ||
             grid[row][col] ==0 ||
             (1 < grid[row][col] && grid[row][col] < min)
        ) {
            return;
        }

        // visited[row][col] = true;
        
        grid[row][col] = min;
        
        dfs(row+1, col,min+1);
        dfs(row-1, col,min+1);
        dfs(row, col+1,min+1);
        dfs(row, col-1,min+1);

    }

    public static void main(String[] args) {
        int[][] grid = {
                        {2,1,1},
                        {1,1,0},
                        {0,1,1},
                    };
        RottenOranges ob = new RottenOranges();
        System.out.println(ob.orangesRotting(grid));
    }
   
    
}
