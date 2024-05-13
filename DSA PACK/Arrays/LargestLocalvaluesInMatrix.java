public class LargestLocalvaluesInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,2,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
        };
        largestLocal(grid);
    }
    public static void largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];
        for (int row = 1; row < grid.length-1; row++) {
            for (int col = 1; col < grid[row].length-1; col++) {
                int max = findMax(grid,row,col);
                ans[row - 1][col - 1] = max;
            }
        }
    }
    private static int findMax(int[][] grid, int row, int col) {
       int max = Integer.MIN_VALUE;
        for (int i = row-1; i < row-1+3; i++) {
            for (int j = col-1; j < col-1+3; j++) {
                System.out.print(grid[i][j]+" ");
                max = Math.max(max, grid[i][j]);
            }
            System.out.println();
        }
       return max;
    }
}
