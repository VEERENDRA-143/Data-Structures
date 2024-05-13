public class MaximumSubsequenceScore {
    public static void main(String[] args) {
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        maxScore(nums1, nums2, k);
    }
    public static void maxScore(int[] nums1, int[] nums2, int k) {
        int maxScore = 0;
       
        for (int i = 0; i < nums2.length; i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            if (i+k <= nums2.length) {
                for (int j = i; j < i+k; j++) {
                    sum+=nums1[j];
                    min = Math.min(min, nums2[j]);
                }
                maxScore = Math.max(maxScore,sum*min);
            }
            
        }
        // while (windowSize < nums1.length) {
        //     int sum = findSum(nums1,start,windowSize);
        //     int min = findMin(nums2,start,windowSize);
        //     maxScore = Math.max(maxScore,sum*min);
        //     start++;
        //     windowSize++;
        // }
        System.out.println(maxScore);
    }
    private static int findMin(int[] nums2, int start, int windowSize) {
       int min = Integer.MAX_VALUE;
       for (int i = start; i < windowSize; i++) {
            min = Math.min(min, nums2[i]);
       }
       return min;
    }
    private static int findSum(int[] nums1, int start, int windowSize) {
       int sum = 0;
       for (int i = start; i < windowSize; i++) {
            sum+=nums1[i];
       }
       return sum;
    }
}
