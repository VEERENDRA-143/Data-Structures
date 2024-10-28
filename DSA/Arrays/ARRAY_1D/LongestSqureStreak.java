import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSqureStreak {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7};
        System.out.println(longestSquareStreak(nums));
    }
    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
       
        map.put(nums[0],1);
        for(int ele :  nums){
            int sqrt = (int)Math.sqrt(ele);
            if(map.containsKey(sqrt) && sqrt*sqrt == ele){
                map.put(ele,map.getOrDefault(sqrt, 0)+1);
            }else{
                map.put(ele,1);
            }
        }
        System.out.println(map);
        int ans = 0;
        for(int val : map.values()){
            ans = Math.max(ans,val);
        }
        return ans >=2 ? ans : -1;
    }
}
