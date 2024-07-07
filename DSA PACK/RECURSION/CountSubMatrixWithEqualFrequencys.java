import java.util.*;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        Pair[][] dp = new Pair[grid.length + 1][grid[0].length + 1];
        int ans = 0;
        
        for(int i = 0; i <= grid.length; i++)
            dp[i][0] = new Pair(0, 0);
        for(int j = 0; j <= grid[0].length; j++)
            dp[0][j] = new Pair(0, 0);
        
        for(int i = 1; i <= grid.length; i++) {
            for(int j = 1; j <= grid[0].length; j++) {
                int prevXCount = dp[i - 1][j].x + dp[i][j - 1].x - dp[i - 1][j - 1].x;
                int prevYCount = dp[i - 1][j].y + dp[i][j - 1].y - dp[i - 1][j - 1].y;
                
                int currXCount = 0, currYCount = 0;
                if(grid[i - 1][j - 1] == 'X')
                    currXCount = 1;
                else if(grid[i - 1][j - 1] == 'Y')
                    currYCount = 1;
                
                currXCount += prevXCount;
                currYCount += prevYCount;
                
                if(currXCount > 0 && currXCount == currYCount)
                    ans++;
                
                dp[i][j] = new Pair(currXCount, currYCount);
            }
        }
        
        return ans;
    }
    
    private class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

public class CountSubMatrixWithEqualFrequencys {

    public class Pair {
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int f(char[][] grid){
        int n = grid.length;
        int m= grid[0].length;

        Pair[][] dp =new Pair[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = new Pair(0, 0);
            for(int j = 0; j <= m; j++){
                dp[i][j] = new Pair(0, 0);
            }
        }
       

        if (grid[0][0] == 'X') {
            dp[0][0].x = 1;
        }
        else if (grid[0][0] == 'Y') {
            dp[0][0].y = 1;
        }

        for (int i = 1; i < m; i++) {
            if (grid[0][i] == 'X') {
                dp[0][i].x = dp[0][i-1].x +1;
                dp[0][i].y = dp[0][i-1].y;

            }else if (grid[0][i] == 'Y') {
                dp[0][i].x = dp[0][i-1].x;
                dp[0][i].y = dp[0][i-1].y +1;
            }else{
                dp[0][i].x = dp[0][i-1].x;
                dp[0][i].y = dp[0][i-1].y;
            }
        }

        for (int i = 1; i < n; i++) {

            if (grid[i][0] == 'X') {
                dp[i][0].x = dp[i-1][0].x + 1;
                dp[i][0].y = dp[i-1][0].y;
            }
            else if (grid[i][0] == 'Y') {
                dp[i][0].x = dp[i-1][0].x;
                dp[i][0].y = dp[i-1][0].y +1;
            }else{
                dp[0][i].x = dp[0][i-1].x;
                dp[0][i].y = dp[0][i-1].y;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ( grid[i][j] == 'X') {
                    dp[i][j].x = dp[i-1][j].x + dp[i][j-1].x + dp[i-1][j-1].x + 1;
                    dp[i][j].y = Math.max(dp[i-1][j].y, dp[i][j-1].y) + dp[i-1][j-1].y;

                }else if (grid[i][j] == 'Y') {

                    dp[i][j].x = Math.max(dp[i-1][j].x, dp[i][j-1].x) + dp[i-1][j-1].x;
                    dp[i][j].y = dp[i-1][j].y +dp[i][j-1].y + dp[i-1][j-1].y + 1;

                }else{

                    dp[i][j].x = dp[i-1][j].x + dp[i][j-1].x + dp[i-1][j-1].x;
                    dp[i][j].y = dp[i-1][j].y + dp[i][j-1].y + dp[i-1][j-1].y;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print("("+ dp[i][j].x+" , "+dp[i][j].y +")"+"  ");
            }
            System.out.println();
        }

        return 0;

    }
    public static void main(String[] args) {
        char[][] grid = {
            {'X','Y','.'},
            {'Y','.','.'},
        };
        
        CountSubMatrixWithEqualFrequencys o = new CountSubMatrixWithEqualFrequencys();
        System.out.println(o.f(grid));
    }   
    public static int numberOfSubmatrices(char[][] grid) {
        
        return 0;
    }
    

}


