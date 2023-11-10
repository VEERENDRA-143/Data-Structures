import java.util.Arrays;

public class smallerNumbersThanCurrent {

    public static void main(String[] args) {
        int[] arr={6,5,4,8};
        int[] ans = find(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] find(int[] nums){
        int[] ans=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            ans[i] =  CountItems(nums,nums[i],count);
        }
        return ans;
    }

    private static int CountItems(int[] arr, int i, int count) {
        
        for (int j : arr) {
            if (j<i) {
                count++;
            }
        }
        return count;
    }
}