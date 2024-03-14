public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {2,3,4,5};
        System.out.println(getCommon(nums1, nums2));
    }
    public static int getCommon(int[] nums1, int[] nums2) {
        if (nums1[0]==nums2[0]) {
            return nums1[0];
        }
        int min;
        min = nums1[0]>nums2[0]? nums1[0]:nums2[0];
        if (nums1.length<nums2.length) {
           boolean res =  checkNumExists(nums1,min);
           if (res) {
                return min;
           }
        }
        else{
            boolean res =  checkNumExists(nums2,min);
            if (res) {
                return min;
            }
        }
        return -1;
    }
    private static boolean checkNumExists(int[] nums1, int min) {
        int start=0;
        int end = nums1.length-1;
        int mid;
        while (start<=end) {
            mid=(start+end)/2;
            if (nums1[mid]==min) {
                return  true;
            }
            if (nums1[mid]<min) {
                start=mid+1;
            }
            if (nums1[mid]>min) {
                end = mid-1;
            }
        }
        return false;
    }
}
