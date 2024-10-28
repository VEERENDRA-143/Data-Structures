public class MinimumCostHomecoming {
    public static void main(String[] args) {
        int[] startPos = {1, 0};
        int[] homePos = {2, 3};
        int[] rowCosts ={5, 4, 3};
        int[] colCosts = {8, 2, 6, 7};
        minCost(startPos, homePos, rowCosts, colCosts);
    }
    public static void minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int[][] dp= new int[rowCosts.length][colCosts.length];
        int ans = f(startPos[0], startPos[1], rowCosts, colCosts, homePos,dp);
        System.out.println(ans);
    }
    public static int f(int row, int col,int[] rowCosts, int[] colCosts,int[] homePos,int[][] dp){
        if(row < 0 || col < 0 || row >= rowCosts.length || col >= colCosts.length){
            return 0;
        }

        if(row == homePos[0] && col == homePos[1]){
            return 0;
        }
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        int  up     =  rowCosts[row] +  f(row-1,col, rowCosts, colCosts, homePos, dp);
        int  down   =  rowCosts[row] +  f(row+1, col, rowCosts, colCosts, homePos,dp);
        int  left   =  colCosts[col] +  f(row, col-1, rowCosts, colCosts, homePos, dp);
        int  right  =  colCosts[col] +  f(row, col + 1, rowCosts, colCosts, homePos,dp);
        System.out.println(up + " " + down + " " + left + " " + right);
        return dp[row][col] = Math.min(Math.min(left,right),Math.min(up,down));
    }
}
