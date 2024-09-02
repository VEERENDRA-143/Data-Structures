// https://leetcode.com/problems/maximum-xor-score-subarray-queries/description/

import java.util.Arrays;

public class MaxSubArrayXORValue {
    public static void main(String[] args) {
        int[] nums = {2,8,4,32,16,1};
        int[][] queries = {
            {0,2},
            {1,4},
            {0,5}
        };
        maximumSubarrayXor(nums, queries);
    }
    public static void maximumSubarrayXor(int[] nums, int[][] queries) {
        int n=  nums.length;

        int[][] t = new int[n][n];
        for (int j = 0; j < t.length; j++) {
            t[j][j] = nums[j];
        }
        for (int[] is : t) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                t[i][j+i] = t[i][i+j-1]^t[i+1][i+j];
            }
        }
        for (int[] is : t) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                t[i][j+i] = Math.max( 
                    Math.max(t[i][i+j-1],t[i][i+j]),
                    t[i+1][i+j]
                );
            }
        }
        for (int[] is : t) {
            System.out.println(Arrays.toString(is));
        }

        int[] result = new int[queries.length];
        int ind = 0;
        for (int[] query : queries) {
            result[ind++] = t[query[0]][query[1]];
        }
        System.out.println();
        System.out.println(Arrays.toString(result));
        
    }

}
