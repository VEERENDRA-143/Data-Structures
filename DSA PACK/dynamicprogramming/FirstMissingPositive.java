import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums={1,1,-1,0,2,3,4,6};
        System.out.println(firstMissingpositiveNum(nums));;
    }
    public static int firstMissingpositiveNum(int[] nums){
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int[] freq = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0) {
                freq[nums[i]]++;
            }
        }
        int index= -1;
        for (int i : freq) {
            // System.out.println(i);
            index++;
            if (i ==0 ) {
                return index;
            }
        }
        return max+1;
    }
}
