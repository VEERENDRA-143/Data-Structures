import java.util.Arrays;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums={-1,-1,-1,-1,0,1};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            left[i]=sum;
        }
        sum=0;
        for (int i = nums.length-1; i >=0; i--) {
            sum+=nums[i];
            right[i]=sum;
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < right.length; i++) {
            if (left[i]==right[i]) {
                return i;
            }
        }
        return -1;
    }
}
