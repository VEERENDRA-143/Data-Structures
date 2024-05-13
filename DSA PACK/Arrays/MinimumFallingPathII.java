import java.util.Arrays;

public class MinimumFallingPathII {
    public static void main(String[] args) {
        int[][] grid = {
                        {99,1,60,4,3},
                        {49, 1, 10, 42, 56},
                        {87, 28, 78, 60, 5},
                        {23, 12, 53, 69, 6},
                        {3, 5, 15, 6, 7}
                    };
                    minFallingPathSum(grid);

    }
    public static void minFallingPathSum(int[][] grid) {
        minFallingPathSum(grid, 0, 0);
    }
    private static void minFallingPathSum(int[][] grid, int row, int col) {


        if (row==-1 || col==-1) {
            return;
        }
        if (row==-1 && col==-1) {
            return;
        }
        if (row>=grid.length && col>=grid.length) {
            return;
        }
        if (row>=grid.length || col>=grid.length) {
            return;
        }

        System.out.print(grid[row][col]+", ");

        minFallingPathSum(grid, row+1, col+1);

        minFallingPathSum(grid, row-1, col+1);

        minFallingPathSum(grid, row+1, col-1);

        minFallingPathSum(grid, row, col+1);

        minFallingPathSum(grid, row+1, col);

        return;

    }

}

class Solution {
    public int minFallingPathSum(int[][] grid) {
        // We can select any element from the first row. We will select
        // the element which leads to minimum sum.
        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, optimal(0, col, grid));
        }

        // Return the minimum sum
        return answer;
    }

    // The optimal(row, col) function returns the minimum sum of a
    // falling path with non-zero shifts, starting from grid[row][col]
    int optimal(int row, int col, int[][] grid) {
        // If the last row, then return the value of the cell itself
        if (row == grid.length - 1) {
            return grid[row][col];
        }

        // Select grid[row][col], and move on to next row. For next
        // row, choose the cell that leads to the minimum sum
        int nextMinimum = Integer.MAX_VALUE;
        for (int nextRowCol = 0; nextRowCol < grid.length; nextRowCol++) {
            if (nextRowCol != col) {
                nextMinimum = Math.min(nextMinimum, optimal(row + 1, nextRowCol, grid));
            }
        }

        // Minimum cost from this cell
        return grid[row][col] + nextMinimum;
    }
}
