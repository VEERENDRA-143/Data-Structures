import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums={3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        if (nums.length ==1|| nums.length==0) {
            return -1;
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-nums[i+1]==0) {
                return nums[i+1];
            }
        }
        return -1;

    }
}
