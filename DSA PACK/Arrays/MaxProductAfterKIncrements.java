import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProductAfterKIncrements {
    public static void main(String[] args) {
        int[] nums = {0,4};
        int k  = 5;
        System.out.println(maximumProduct(nums, k));
    }
    public static int maximumProduct(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i: nums) queue.offer(i);
        for(int i=0;i<k;i++){
            queue.offer(queue.poll()+1);
        }
        long prod = 1;
        int mod = 1_000_000_007;
        while(!queue.isEmpty()) prod = (prod*queue.poll())%mod;
        return (int)prod;
    }
}
