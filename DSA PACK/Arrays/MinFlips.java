public class MinFlips {
    public static void main(String[] args) {
        int[][] grid = {
            {0,1},
            {0,1},
            {0,0},
        };
        System.out.println(minFlips(grid));
    }   
    public static int minFlips(int[][] grid) {
        
        return Math.min(solveRow(grid) , solveCol(grid));
    }
    private static int solveRow(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int start = 0;
            int end = row.length-1;
            while (start < end) {
                if (row[start] != row[end]) {
                    c++;
                }
                start++;
                end--;
            }
        }
        return c;
    }
    private static int solveCol(int[][] grid) {
        
        int c = 0;

        int m = grid[0].length;
        int n = grid.length;
        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n-1;
            while (start <end) {
                if (grid[start][i] != grid[end][i]) {
                    c++;
                }
                start++;
                end--;
            }
        }
        return c;
    }
}
