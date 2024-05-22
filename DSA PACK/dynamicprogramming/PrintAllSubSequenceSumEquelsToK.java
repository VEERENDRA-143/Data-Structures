import java.util.*;
public class PrintAllSubSequenceSumEquelsToK { 
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,5};
        int k = 8;
        List<List<Integer>> subsets = new ArrayList<>();
        genareteSubsequences(nums, 0, new ArrayList<>(), subsets, k);
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }
    }
    
    // Printing all subsequnces whose subsequnce sum is equal to k
    public static void genareteSubsequences(int[] nums,int index, List<Integer> subset,List<List<Integer>> subsets,int k){
        if (index == nums.length) {
            
            int sum= 0;
            for (Integer ele : subset) {
                sum+=ele;
            }
            if (sum == k) {
                subsets.add(new ArrayList<>(subset));
            }
            return;
        }

        subset.add(nums[index]);
        genareteSubsequences(nums, index+1, subset, subsets,k);
        subset.remove(subset.size()-1);
        genareteSubsequences(nums, index+1, subset, subsets,k);
    }
    
}
