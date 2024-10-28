import java.util.*;
public class MakeArithamticProgression {
    public static void main(String[] args) {
        int x = 7;
        int y = 4;
        int z = 3;
        findArthmatic(x, y, z);
    }

    public static void findArthmatic(int x,int y,int z){
        int ap = (x+z) / 2;
        if (ap == y) {
            System.out.println(0);
            return;
        }
        
        int[][] dp = new int[x+1][z+1];
        int ans = f(x, y, z,dp);
        System.out.println(ans);
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
    }
    public static int f(int x,int y,int z,int[][] dp){
        if (y == Math.abs((x+z)/2)) {
            return 0;
        }
        if (dp[x][z] != 0) {
            return dp[x][z];
        }
        int first = 1 + f(x-1,y,z,dp);
        int second = 1 + f(x,y,z-1,dp);
        return dp[x][z] = Math.min(first,second);
    }

}
