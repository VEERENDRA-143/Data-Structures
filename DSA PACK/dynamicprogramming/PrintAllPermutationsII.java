// https://leetcode.com/problems/permutations-ii/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrintAllPermutationsII {
    
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }
    public static void permuteUnique(int[] nums) {
        boolean[] freq = new boolean[nums.length];
        HashSet<List<Integer>> set   = new HashSet<>();
        getPermutations(nums, new ArrayList<>(), set, freq);
        System.out.println(set);
    }
    public static void getPermutations(int[] nums,List<Integer> sublist,HashSet<List<Integer>> set,boolean[] freq ){
        if (sublist.size() == nums.length) {
            set.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                sublist.add(nums[i]);
                getPermutations(nums, sublist, set, freq);
                sublist.remove(sublist.size()-1);
                freq[i] = false;
            }
        }
    }
}
