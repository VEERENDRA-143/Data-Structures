import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Rough{
    public static void main(String[] args) {
        int[] nums = {2,5,1,7,10};
	    int k = 14;
		System.out.println(lengOfmaxSubarray(nums,k));
    }
    public static int lengOfmaxSubarray(int[] nums,int target){
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen=-1;
        Queue<List<Integer>> q= new LinkedList<>();
        while(right < nums.length){
            
            sum += nums[right];

            if(sum > target){
                while(sum > target && left < right){
                    sum -= nums[left];
                    left++;
                }
            }
            
            if(sum <= target ){
                if(right-left+1 >= maxLen){
                    ArrayList<Integer> list = new ArrayList<>();
                    maxLen = Math.max(maxLen,right-left+1);
                    // System.out.println(maxLen);
                    for(int i =left;i <= right;i++){
                        list.add(nums[i]);
                    }
                    q.poll();
                    q.offer(list);
                    System.out.println(list);
                }
                right++;
            }
            
        }
        System.out.println(q);
        System.out.println(q.peek());
        return maxLen;
    }
}