
public class DoungianGame {
    public static void main(String[] args) {
        int[][] dungeon ={
            {-2,-3,3},
            {-5,-10,1},
            {10,30,-5}
        };
        calculateMinimumHP(dungeon);
    }
    public static void calculateMinimumHP(int[][] dungeon) {
        // int ans =  calMinpath(0,0,dungeon);
        Integer[][] dp = new Integer[dungeon.length][dungeon[0].length];
        int ans = memoize(0, 0, dungeon, dp);
        if (ans == 0 && dungeon[0][0] < 0) {
            ans = dungeon[0][0];
        }
        System.out.println(ans >= 0 ? 1: -1*ans+1);
    }

    // Recursive Approch
    private static int calMinpath(int i, int j, int[][] dungeon) {
        if (i == dungeon.length-1 && j == dungeon[0].length-1) {
            return dungeon[i][j]>=0 ? 0: dungeon[i][j];
        }

        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MIN_VALUE;
        }

        int dowWard = calMinpath(i+1, j, dungeon);
        int rightWard = calMinpath(i, j+1, dungeon);

        int val = dungeon[i][j] + Math.max(dowWard, rightWard);

        return val > 0 ? 0 : val;

    }

    // Memoization
    public static int memoize(int i,int j,int[][] dungeon,Integer[][] dp){
        if (i == dungeon.length-1 && j == dungeon[0].length-1) {
            return dungeon[i][j] >= 0 ? 0: dungeon[i][j];
        }
        if ( i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j]  != null) {
            return dp[i][j];
        }
        int dowWard = memoize(i+1, j, dungeon, dp);
        int leftWard = memoize(i, j+1, dungeon, dp);
        int val = dungeon[i][j]+Math.max(dowWard, leftWard);
        return  dp[i][j] = val >=0 ? 0: val;
    }
}
