import java.util.Arrays;

public class DiffBWOnesAndZeros {
    public static void main(String[] args) {
        int[][] grid= {
            {0,1,1},
            {1,0,1},
            {0,0,1}
        };
        onesMinusZeros(grid);
    }
    public static void onesMinusZeros(int[][] grid) {
        int[] cols = new int[grid[0].length];
        int[] rows = new int[grid.length];
        int[][] ans = new int[rows.length][cols.length];
        int index=0;
        for (int i = 0; i < grid[0].length; i++) {
            int onesCol = 0;
            int zerosCol = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    onesCol++;
                }
                
                if (grid[j][i] == 0) {
                    zerosCol++;
                }
               
            }
            cols[index++] = onesCol-zerosCol;
            
        }

        for (int i = 0; i < grid.length; i++) {
            int onesRow = 0;
            int zerosRow = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1) {
                    onesRow++;
                }
                else{
                    zerosRow++;
                }
            }
            rows[i] = onesRow-zerosRow;
        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                ans[i][j] = rows[i]+cols[j];
            }
        }
        for (int[] is : ans) {
            for (int ele : is) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        
    }
}
