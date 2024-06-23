import java.util.Arrays;

public class MInAvgOfSmAndMax {
    public static void main(String[] args) {
        int[] nums ={1,2,3,7,8,9};
        minimumAverage(nums);
    }
    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        double min = Double.MAX_VALUE;
        while (start < end) {
            double avg = ((double)(nums[start])+(double)(nums[end]))/2;
            min = Math.min(avg, min);
            start++;
            end--;
        }
        System.out.println(min);
        return min;
    }
}
