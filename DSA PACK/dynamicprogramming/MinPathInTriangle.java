// https://www.naukri.com/code360/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

public class MinPathInTriangle {
    public static void main(String[] args) {
        int[][] triangle={
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3},
        };
        System.out.println(minPathTriangle(triangle, triangle.length));
    }
    public static int minPathTriangle(int[][] triangle,int n){
        return f(0,0,triangle,n);
    }
    private static int f(int row, int col, int[][] triangle, int n) {
        
        if (row == n-1) {
            return triangle[row][col];
        }
        
        int down = triangle[row][col] + f(row+1, col, triangle, n);
        int diagonal = triangle[row][col] + f(row+1, col+1, triangle, n);
        return Math.min(down, diagonal);

    }

    public static int Memoization(int row,int col,int[][] triangle,int n,int[][] dp){
        if (row == n-1) {
            return triangle[row][col];
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int down = triangle[row][col] + Memoization(row+1, col, triangle, n, dp);
        int diagonal = triangle[row][col] + Memoization(row+1, col+1, triangle, down, dp);
        return dp[row][col] = Math.min(down, diagonal);
    }
}
