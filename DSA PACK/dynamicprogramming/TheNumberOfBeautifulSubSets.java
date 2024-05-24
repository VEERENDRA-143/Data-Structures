import java.util.*;

public class TheNumberOfBeautifulSubSets {
    public static int count = 0;

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 9, 10, 3 };
        int k = 1;
        beautifulSubsets(nums, k);
    }

    public static void beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        genarateSubsets(nums, 0, new ArrayList<>(), ans, k);
        // System.out.println(ans);
        // System.out.println("count =  "+count);
        Set<Integer> set=new HashSet<>();
        System.out.println(countBeautifulSubSets(nums,k,set,0));
    }

    public static void genarateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> ans, int k) {
        if (index == nums.length) {
            // if (subset.size() <=2) {
            //     ans.add(new ArrayList<>(subset));
            // }
            int total = 0;
            for (int i = 0; i < subset.size(); i++) {
                total = Math.abs(total-subset.get(i));
            }
            
            // System.out.println(total);

            return;
        }

        subset.add(nums[index]);
        genarateSubsets(nums, index + 1, subset, ans, k);
        subset.remove(subset.size() - 1);
        genarateSubsets(nums, index + 1, subset, ans, k);
    }

    private static int countBeautifulSubSets(int[] nums, int k, Set<Integer> set, int index){
        // Base case: Return 1 for a subset of size 1
        if(index==nums.length){
            System.out.println(set);
            return 1;
        }
        //count subsets where nums[index] is skipped
        int totalCount = countBeautifulSubSets(nums, k, set, index+1);

        if(!set.contains(nums[index]-k)){
            set.add(nums[index]);
        
            totalCount+=countBeautifulSubSets(nums, k, set, index+1);
            set.remove(nums[index]);
        }
        return totalCount;
    }
}
