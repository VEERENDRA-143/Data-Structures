public class MiniNumOfDaystoDisconnectIsLand {

    private static int[][] DIRECTIONS = {{0,+1},{+1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        int ans = minDays(grid);
        System.out.println(ans);
    }
    public static int minDays(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int initailIslandsCount = countIslands(grid);

        if (initailIslandsCount != 1) {
            return 0;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);
                if (newIslandCount != 1) {
                    return 1;
                }
                grid[row][col] =1;
            }
        }
        return 2;
    }
    private static int countIslands(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int isLandsCount = 0;
        for (int row = 0; row < n; row++) {
            for(int col = 0;col < m ;col++){
                
                if (grid[row][col] == 1 && !visited[row][col]) {
                    exploreIsland(grid,row,col,visited);
                    isLandsCount+=1;
                }
                visited[row][col] = true;
            }
        }

        return isLandsCount;

    }
    private static void exploreIsland(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];;
            int newCol = col + direction[1];
            if (isValidCell(newRow,newCol,grid,visited)) {
                exploreIsland(grid,newRow,newCol,visited);
            }
        }
    }

    private static boolean isValidCell(int row, int col, int[][] grid,boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return row>=0 && col>=0 && row<n && col<m && !visited[row][col] && grid[row][col]==1;
    }
}
