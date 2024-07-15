public class NoOfIncreseingPaths {
    public static void main(String[] args) {
        int[][] grid = {
            {1,1},
            {3,4}
        };
        System.out.println(countPaths(grid));
    }
    public static int countPaths(int[][] grid) {
        int mod = (int) 1e9+7;
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = ans + f(i, j, grid);
                ans = ans%mod;
            }
        }
        return ans;
    }
    public static int f(int row,int col,int[][] graph) {

        int c = 0;
        if (row <0 || col <0 || row >= graph.length || col >= graph[0].length) {
            return 0;
        }
        if (row >0 && graph[row][col] < graph[row-1][col]) {
            c = c +  1 + f(row-1, col, graph);
        }
        if (row < graph.length && graph[row][col] < graph[row+1][col]) {
            c = c + 1 + f(row+1, col, graph);
        }
        if (col >0 && graph[row][col] < graph[row][col-1]) {
            c = c + 1 + f(row, col-1, graph);
        }
        if (col < graph[0].length -1 && graph[row][col] < graph[row][col+1]) {
            c = c +  1 + f(row, col+1, graph);
        }
        
        return c;
    }

}
