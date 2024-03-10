import java.util.Arrays;

public class MeargeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1};

        int  m = 1,n = 0;

        int[] nums2 = {};

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n==0) {
            System.out.println(Arrays.toString(nums1));
            return;
        }

        if (m==0) {
            nums1=nums2;
            System.out.println(Arrays.toString(nums1));
            return;
        }
        while (nums1.length != m) {
            nums1[m]=nums2[m-n];
            m++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
