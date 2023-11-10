
import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums={3,1,2,4};
        int[] ans = sortArrayByParity(nums);
        System.out.println(Arrays.toString(ans));
    }
    static int[] sortArrayByParity(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int[] arr= new int[nums.length];
        for(int num : nums) {
            if(num%2==0) arr[start++] = num;
            else arr[end--] = num;
        }
        
        return arr;
    }
}
