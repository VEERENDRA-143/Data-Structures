import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums={4,0,5,-5,3,3,0,-4,-5};
        int target=-2;
        threeSumClosest(nums, target);
    }
    public static int threeSumClosest(int[] nums, int target){
        int sum=Integer.MAX_VALUE;
        int start = 0;
        int mid = 1;
        int end = 2;
        int min = Integer.MAX_VALUE;

        ArrayList<Integer> sumList  =  new ArrayList<>();
        ArrayList<Integer> closest  =  new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (end<nums.length) {
                sumList.add(Math.min(sum, nums[start]+nums[mid]+nums[end]));
                closest.add(Math.abs(sumList.get(start)-target));
                start++;
                end++;
                mid++;
            }
        }
        int index = 0;
        for (Integer integer : closest) {
            if (min>integer) {
                min=integer;
                index++;
            }
        }
        return sumList.get(index-1);
    }
}
