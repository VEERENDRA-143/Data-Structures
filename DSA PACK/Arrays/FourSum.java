import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = 0;
        fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int mod = (int)1e9;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum =( nums[i] %mod + nums[j]%mod + nums[k]%mod +nums[l]%mod)%mod;
                    if (sum < target) {
                        // set.add(nums[k]);
                        k++;
                    } else if (sum > target) {
                        // set.add(nums[l]);
                        l--;
                    } else if(sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        if (!set.contains(list)) {
                            ans.add(list);
                        }
                        
                        System.out.println(list);
                        set.add(new ArrayList<>(list));
                        k++;
                        l--;
                        while (k >= 0 && k < n-1 && (nums[k] == nums[k + 1]))
                            k++;
                        while (l >= 0 && l < n - 1 && (nums[l] == nums[l + 1]))
                            l--;
                    }
                }
            }
        }
        System.out.println(ans);
        System.out.println(set);
        return ans;
    }
}
