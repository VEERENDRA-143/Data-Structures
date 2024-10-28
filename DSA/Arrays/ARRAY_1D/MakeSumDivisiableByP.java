
// https://leetcode.com/problems/make-sum-divisible-by-p/

import java.util.*;

public class MakeSumDivisiableByP {
    public static void main(String[] args) {
        int[] arr= {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        int p = 148;
        minSubarray(arr, p);
    }
    public static void minSubarray(int[] nums, int p) {
        int sum =0 ;
        for (int ele : nums) {
            sum = (sum+ele)%p;
        }
        int leftOver = sum%p;
        if (leftOver == 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sumValue = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++){

            sumValue = (sumValue + nums[i])%p;
            int remainingSum = (sumValue - leftOver+p) % p;

            if (map.containsKey(remainingSum)) {
                minLength = Math.min(minLength, i - map.get(remainingSum));
            }
            map.put(sumValue,i);
        }
        System.out.println(minLength);
    }
}
