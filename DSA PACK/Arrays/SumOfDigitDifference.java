public class SumOfDigitDifference {
    public static void main(String[] args) {
        int[] nums = {50,28,48};
        System.out.println(sumDigitDifferences(nums));
    }
    public static long sumDigitDifferences(int[] nums) {
        String s[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = Integer.toString(nums[i]);
            // System.out.println(s[i]);
        }
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = i+1; j < s.length; j++) {
                int diff = findDiff(s[i],s[j]);
                count+=diff;
            }
        }
        return count;
    }
    private static int findDiff(String string, String string2) {
        int diffCount =0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string2.charAt(i)) {
                diffCount += Math.abs((string.charAt(i) - '0')-(string2.charAt(i)-'0'));
            }
        }
        return diffCount;
    }
}




// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         int n = nums.length;
//                 // Handle the edge case where nums has only one element
//         if (n == 1) {
//             boolean[] result = new boolean[queries.length];
//             for (int i = 0; i < queries.length; i++) {
//                 result[i] = true;  // Any subarray of a single element is trivially special
//             }
//             return result;
//         }
//         int[] parityChange = new int[n - 1];
        
//         // Preprocessing: Fill the parityChange array
//         for (int i = 0; i < n - 1; i++) {
//             if ((nums[i] % 2) != (nums[i + 1] % 2)) {
//                 parityChange[i] = 1;
//             } else {
//                 parityChange[i] = 0;
//             }
//         }
        
//         // Create the prefix sum array for parityChange
//         int[] prefixSum = new int[n - 1];
//         prefixSum[0] = parityChange[0];
//         for (int i = 1; i < n - 1; i++) {
//             prefixSum[i] = prefixSum[i - 1] + parityChange[i];
//         }
        
//         // Initialize the result array
//         boolean[] result = new boolean[queries.length];
        
//         // Resolve each query using the prefix sum array
//         for (int i = 0; i < queries.length; i++) {
//             int from = queries[i][0];
//             int to = queries[i][1];
            
//             if (to - from == 0) {
//                 result[i] = true; // A single element is trivially special
//             } else {
//                 int changes;
//                 if (from == 0) {
//                     changes = prefixSum[to - 1];
//                 } else {
//                     changes = prefixSum[to - 1] - prefixSum[from - 1];
//                 }
                
//                 // The subarray is special if all adjacent pairs have different parity
//                 result[i] = (changes == (to - from));
//             }
//         }
        
//         return result;
//     }
// }