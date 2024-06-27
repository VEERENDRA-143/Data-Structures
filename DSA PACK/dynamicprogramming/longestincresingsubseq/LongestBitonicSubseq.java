import java.util.*;
public class LongestBitonicSubseq {
    public static void main(String[] args) {
        int[] nums={5,7,9};
        System.out.println(LongestBitonicSequence(nums));
    }
    public static int LongestBitonicSequence(int[] nums){
        int n = nums.length;

        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);


        // Longest Incresing subsequence from left to right
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev]  ) {
                    dp1[i] = 1+ dp1[prev];
                }
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);


        // Longest Incresing subsequence from right to left
        for (int i = n-1; i >= 0; i--) {
            for (int prev = n-1; prev > i; prev--) {
                if (nums[i] > nums[prev] ) {
                    dp2[i] = 1+ dp2[prev];
                }
            }
        }

        int max = -1;

        for (int i = 0; i < dp1.length; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        return max;
    }
}