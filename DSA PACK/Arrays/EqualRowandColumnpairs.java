import java.util.Arrays;

public class EqualRowandColumnpairs {
    public static void main(String[] args) {
        int[][] grid = {
            {3,1,2,2},
            {1,4,4,5},
            {2,4,2,2},
            {2,4,2,2},
        };
        equalPairs(grid);
    }
    public static void equalPairs(int[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean check = findColsandRows(grid,i,j);
                if (check) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean findColsandRows(int[][] grid, int row, int col) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            rows[i] =grid[row][i]; 
            cols[i] =grid[i][col]; 
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
            
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));
        
        return true;
    }
}
