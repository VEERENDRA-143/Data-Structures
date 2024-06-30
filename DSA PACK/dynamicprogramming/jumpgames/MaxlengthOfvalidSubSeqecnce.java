import java.util.ArrayList;
import java.util.List;

public class MaxlengthOfvalidSubSeqecnce {
    public static void main(String[] args) {
        int[] nums= {1,2,3,4};
        System.out.println(maximumLength(nums));
    }

    // https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/

    public static int maximumLength(int[] nums) {
       int dp[][] = new int[nums.length][2], max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2; j++) {
                max = Math.max(max, dp[nums[i] % 2][j] = dp[j][nums[i] % 2] + 1);
            }
        }
        return max;
    }

    // https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/
    
    public static int maximumLength2(int[] nums,int k) {

        int dp[][] = new int[nums.length][k];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {

                int r = (nums[i] + nums[j])%k;

                if (dp[j][r] +1 > dp[i][r]) {

                    dp[i][r] = dp[j][r] +1;

                    if (dp[i][r] > max) {

                        max = dp[i][r];

                    }
                }

            }
        }
        return max+1;
            
    }
    
    
}
