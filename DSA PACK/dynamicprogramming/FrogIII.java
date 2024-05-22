
public class FrogIII {
    public static void main(String[] args) {
        int[] heights = {1, 3, 4 ,5 ,10, 11, 12, 13};
        int n = heights.length;
        int k = 5;
        System.out.println(frogJump(n-1, heights, k));
        System.out.println(frogJumpDp(n-1, heights, k));
    }

    public static int frogJump(int n,int[] heights,int k){
        if (n==0) {
            return 0;
        }
        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            
            if (n-i >=0) {
                int jump = frogJump(n-i, heights, k) + Math.abs(heights[n]-heights[n-i]);
                minSteps = Math.min(jump,minSteps);
            } 
            
        }
        return minSteps;
    }

    public static int frogJumpDp(int n,int[] heights ,int k){
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n ; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k ; j++) {
                if (i-j >= 0) {
                    int jumps = dp[i-j]+Math.abs(heights[n]-heights[n-j]);
                    minSteps = Math.min(minSteps, jumps);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }
    
}