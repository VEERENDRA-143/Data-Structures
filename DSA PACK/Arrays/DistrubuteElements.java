import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;

public class DistrubuteElements {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        resultArray(nums);
    }
    public static void resultArray(int[] nums) {

        int[] ans = new int[nums.length];
        int index=0;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)) {
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }

        for (Integer integer : arr1) {
            ans[index++]=integer;
        }

        for (Integer integer : arr2) {
            ans[index++]=integer;
        }

        System.out.println(Arrays.toString(ans));
    }
}
