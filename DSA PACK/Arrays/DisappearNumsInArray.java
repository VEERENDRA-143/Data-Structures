import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DisappearNumsInArray {
    public static void main(String[] args) {
        int[] nums = {1,1};
        findDisappearedNumbers(nums);
    }
    public static void findDisappearedNumbers(int[] nums) {

        int flag=0;
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                System.out.print(nums[i]+" ");
                list.add(nums[i]);
            }
        }
        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[nums.length-1];
        System.out.println();
        for (int i = start; i < end; i++) {
            if (!list.contains(i)) {
                flag = 1;
                ans.add(i);
                System.out.print(i+" ");
            }
        }
        if (flag == 0) {
            if (list.get(0) == 1) {
                ans.add(start+1);
            }
            else{
                ans.add(start-1);
            }
        }
    }
}
