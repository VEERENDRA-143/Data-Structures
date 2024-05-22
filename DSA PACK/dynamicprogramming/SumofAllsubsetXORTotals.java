import java.util.ArrayList;
import java.util.List;

public class SumofAllsubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        

        subsetXORSum(nums);
    }
    public static void subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        genareteSubsets(nums, 0, new ArrayList<>(), subsets);

       
        int result = 0;
        for (List<Integer> list : subsets) {
            
            int innerResult = 0;
            System.out.println(list);
            for (Integer ele : list) {
                innerResult ^= ele;
            }
            result+=innerResult;
        }

        System.out.println(result);

    }



    // Genarateing subsets from given array ========>>  O(N * (2**N))

    public static void genareteSubsets(int[] nums,int index, List<Integer> subset,List<List<Integer>> subsets){
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        genareteSubsets(nums, index+1, subset, subsets);
        subset.remove(subset.size()-1);
        genareteSubsets(nums, index+1, subset, subsets);
    }

    public static void genareteStringSub(String s,int index,List<String> subset,List<List<String>> subsets){
        if (index == s.length()) {
            subsets.add(subset);
            return;
        }
        subset.add(s.substring(index));
        genareteStringSub(s, index+1, subset, subsets);
        subset.remove(subset.size()-1);
        genareteStringSub(s, index+1, subset, subsets);
    }

    // Otimized Solution with Bit Manupilation  =======>> O(N)
    public static int subsetXORSum2(int[] nums) {
        int result = 0;
        for(int num:nums){
            result |= num;
        }
        return result<<(nums.length-1);
    }
}
