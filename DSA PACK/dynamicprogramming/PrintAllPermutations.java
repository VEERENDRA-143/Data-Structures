// https://leetcode.com/problems/permutations-i/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrintAllPermutations {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        getPermutation(0, nums, new ArrayList<>(), ans,freq);
        System.out.println(ans);
    }
    // Without repetation
    // If we want to do with repatations we can remove the "freq" 
    public static void getPermutation(int index,int[] arr,List<Integer> sub,List<List<Integer>> ans,boolean[] freq){
        if (sub.size() == arr.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                sub.add(arr[i]);
                getPermutation(index+1, arr, sub, ans,freq);
                sub.remove(sub.size()-1);
                freq[i] = false;
            }
            
        }
    }

}
