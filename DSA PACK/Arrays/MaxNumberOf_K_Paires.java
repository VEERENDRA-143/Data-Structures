import java.util.Arrays;

public class MaxNumberOf_K_Paires {
    public static void main(String[] args) {
        int[] nums= {3,1,3,4,3};
        int k = 6;
        maxOperations(nums, k);
    }
    public static void maxOperations(int[] nums, int k) {
        int max= FindMAx(nums);
        int[] arr = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
    }
    private static int FindMAx(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
