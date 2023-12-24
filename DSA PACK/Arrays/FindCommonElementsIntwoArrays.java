import java.util.Arrays;

public class FindCommonElementsIntwoArrays {
    public static void main(String[] args) {
        int[] nums1 = { 3,4,2,3};
        int[] nums2 = { 1,5 };

        System.out.println(Arrays.toString(findIntersectionValues(nums1, nums2)));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[] { Commonelements(nums1, nums2), Commonelements(nums2, nums1) };
    }

    static int Commonelements(int[] nums1, int[] nums2) {
        int count = 0;
        int flag = 0;
        for (int i : nums1) {
            flag = check(i, nums2) ? 1 : 0;
            count += flag;
        }
        return count;
    }

    private static boolean check(int i, int[] nums2) {
        for (int j : nums2) {
            if (i == j) {
                return true;
            }
        }
        return false;
    }
}
