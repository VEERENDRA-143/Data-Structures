public class FindNumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4};
        int[] nums2 = {1,3,4};
        int k = 1;
        numberOfPairs(nums1, nums2, k);
    }
    public static void numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0 ;
        
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i]%(nums2[j]*k) == 0) {
                        count++;
                    }
                }
            }
        
        System.out.println(count);
    }
}
