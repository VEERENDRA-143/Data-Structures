import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] nums={1,4,9,11,12,13,15};
        System.out.println(minimumDifference_High_Low(nums, 3));
    }

    static int minimumDifference_High_Low(int[] nums,int k){
        if(k == 1){
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = k-1;
        while(j < nums.length){
            min = Math.min(min, nums[j] - nums[i]); //Finding the min
            i++;
            j++;
        }
        return min;
        
    }

}
