
import java.util.Arrays;

public class MedieanOftwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length==1) {
            return (double)nums2[0];
        }
        if (nums2.length == 0 && nums1.length==1) {
            return (double)nums1[0];
        }
        int[] arry = new int[nums1.length+nums2.length];
        for (int i=0;i<nums1.length;i++) {
            arry[i] = nums1[i];
        }
        for (int i=0;i<nums2.length;i++) {
            arry[nums1.length+i]= nums2[i];
        }
        Arrays.sort(arry);
        // System.out.println(Arrays.toString(arry));
        // System.out.println(arry[arry.length/2]);
        
        double x = arry[arry.length/2];
        double y = arry[(arry.length/2)-1];
        

        return (arry.length%2 == 0)?(x+y)/2:x;
        
    }
}
