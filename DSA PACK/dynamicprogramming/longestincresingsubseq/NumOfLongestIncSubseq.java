// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

import java.lang.reflect.Array;
import java.util.*;
public class NumOfLongestIncSubseq {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(NoOfLIS(nums));
    }
    public static int NoOfLIS(int[] nums){

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                }
                else if (nums[prev] < nums[i] && 1 + dp[prev]  == dp[i]) {
                    // increse count
                    count[i] += count[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int c = 0;
        for (int i = 0; i < count.length; i++) {
            if (dp[i] == max) {
                c += count[i];
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        return c;
    }
}
