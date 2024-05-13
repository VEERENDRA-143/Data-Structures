import java.util.Arrays;

public class ApplyOperationstoAnArray {
    public static void main(String[] args) {
        int[] nums = {0,1};
        applyOperations(nums);
    }
    public static void applyOperations(int[] nums) {
        int i = 0;
        int j = i+1;
        int index=0;
        int[] ans = new int[nums.length];
        while (j != nums.length) {
            
            if (nums[i] == nums[j]) {

                nums[i] = nums[i]*2;
                nums[j] = 0;
            }
            i++;
            j++;
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                ans[index++] = nums[k];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
