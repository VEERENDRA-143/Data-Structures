import java.util.ArrayList;

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        isPossibleToSplit(nums);
    }
    public static boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        int max =-1;
        for(int i=0 ; i<n; i++){
             max = Math.max(max,nums[i]);

        }
        int[] temp = new int[max+1];
        for(int i =0;i<n;i++){
            temp[nums[i]]++;
        }
        for(int i =0; i<temp.length;i++){
            if(temp[i]>2)
            return false;
        }
        return true;
    }
}
