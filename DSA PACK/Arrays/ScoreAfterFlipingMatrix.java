import java.util.Arrays;

public class ScoreAfterFlipingMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,1},
            {1,0,1,0},
            {1,1,0,0}
        };
        matrixScore(grid);
    }
    public static void matrixScore(int[][] grid) {
        // changing rows
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = grid[i][j] ==0?1:0;
                    // if (grid[i][j] == 0) {
                    //     grid[i][j] = 1;
                    // }
                    // else{
                    //     grid[i][j] = 0;
                    // }
                }
            }
        }
        // Changing Columns
        for (int i = 0; i < grid[0].length; i++) {
            boolean hasZeros = chekZeros(grid,i);
            if (hasZeros) {
                for (int j = 0; j < grid.length; j++) {
                    grid[j][i] = grid[j][i] == 1 ? 0 : 1 ;
                    // if (grid[j][i] == 1) {
                    //     grid[j][i] = 0;
                    // }
                    // else{
                    //     grid[j][i] = 1;
                    // }
                }
            }
        }

        for (int[] is : grid) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
        
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            int exp = 0;
            for (int j = grid[i].length-1; j >=0; j--) {
                System.out.print(grid[i][j]+" ");
                rowSum += grid[i][j] * (int)(Math.pow(2, exp));
                exp++;
            }
            ans += rowSum;
            System.out.println();
        }

        System.out.println("Answer = "+ans);
        
    }
    private static boolean chekZeros(int[][] grid, int col) {
        int zeros = 0;
        int ones = 0;
        // System.out.println();
        for (int j = 0; j < grid.length; j++) {
            // System.out.print(grid[j][col]+" ");
            ones = grid[j][col] == 1 ? ones+1:zeros++;
            // if (grid[j][col] == 1) {
            //     ones++;
            // }
            // else{
            //     zeros++;
            // }
        }
        return zeros>ones;
    }
}
