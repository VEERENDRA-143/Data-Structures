import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MagicSqure{
    public static void main(String[] args) {
        int[][] grid = {
                        {7,0,5},
                        {2,4,6},
                        {3,8,1}
                    } ;
        System.out.println(numMagicSquaresInside(grid));
    }
    public static int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n-2 ; i++){
            for(int j = 0; j < m-2;j++){
                if(isMagicSqure(grid,i,j)){
                    ans++;
                    System.out.println("Ans = " + ans);
                }
            }
        }
        return ans;
    }
    
    private static boolean isMagicSqure(int[][] grid,int row,int col){

        // Checking the matrix has unique numbers
        Set<Integer> set = new HashSet<>();
        for(int i = row; i < row + 3 ; i++){
            for(int j = col ; j < col +3 ; j++) {
                if (set.contains(grid[i][j]) || grid[i][j] >= 10 || grid[i][j] == 0) {
                    return false;
                }
                else{
                    set.add(grid[i][j]);
                }
            }
        }

        int sumRequired = grid[row][col] + grid[row][col+1]+grid[row][col +2];
        
        // Row checking
        int r1 = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        int r2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];
        int r3 = grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

        if (r1 != sumRequired || r2 != sumRequired || r3 != sumRequired) {
            return false;
        }

        // Col Sum Checking

        int c1 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
        int c2 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int c3 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];

        if (c1 != sumRequired || c2 != sumRequired || c3 != sumRequired) {
            return false;
        }

        // Diaginal Sum
        int leftDigonal = grid[row][col] + grid[row+1][col+1]+ grid[row+2][col+2];
        int rightDuagonal = grid[row][col+2] + grid[row+1][col+1]+ grid[row+2][col];

        if (leftDigonal != sumRequired || rightDuagonal != sumRequired) {
            return false;
        }

        return true;
        
    }
}