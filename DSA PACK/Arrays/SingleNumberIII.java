import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {-1,0};
        singleNumber(nums);
    }
    public static void singleNumber(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        int[] ans = new int[2];
        int index=0;
        for (int i : set) {
            ans[index++] = i;
        }
        System.out.println(Arrays.toString(ans));
    }
}
