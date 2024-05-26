import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindIntegerAddedtoArrayII {
    public static void main(String[] args) {
        int[] nums1 = {3,5,5,3};
        int[] nums2 = {7,7};
        minimumAddedInteger(nums1, nums2);
    }
    public static void minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer>  list = new ArrayList<>();
        for (int ele : nums2) {
            int ans  = binarySearch(nums1,ele);
            list.add(ans);
        }
        Collections.sort(list);
        System.out.println(nums2[0] - list.get(0));
    }
    private static int binarySearch(int[] nums1, int target) {
        int start = 0;
        int end = nums1.length-1;
        int mid = (start+end)/2;

        while (start < end) {
            if (nums1[mid] == target) {
                return nums1[mid];
            }
            if (nums1[mid] > target) {
                end = mid -1;
            }
            else{
                start = mid +1;
            }
            mid = (start+end)/2;
        }

      return nums1.length%2==0?nums1[mid]:nums1[start];
    }
}
