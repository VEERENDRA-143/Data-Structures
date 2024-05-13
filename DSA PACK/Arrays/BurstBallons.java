import java.util.ArrayList;
import java.util.List;

public class BurstBallons {
    public static void main(String[] args) {
        int[] nums = {9,76,64,21};
        maxCoins(nums);
    }
    public static void maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int cur =1;
        int ans = 0;
        while(!list.isEmpty()) {
            
            if (list.size() >= 3) {
                System.out.println("current = "+list.get(cur));
                ans += list.get(cur-1)*list.get(cur)*list.get(cur+1);
                System.out.println( "remove =  "+ list.remove(cur));
            }
            else if (list.size() == 2){
                System.out.println("current = "+list.get(0));
                ans += list.get(0)*list.get(1);
                System.out.println( "remove =  "+ list.remove(0));
            }
            else if (list.size() ==1) {
                System.out.println( "remove =  "+ list.get(0));
                ans+=list.get(0);
                System.out.println( "remove =  "+ list.remove(0));
            }
            
            // cur++;
        }
        System.out.println(list+" ans = "+ans);

    }
}
