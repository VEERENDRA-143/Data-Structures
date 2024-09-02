//  https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/

import java.util.*;
public class FinalArrayAfterKMul {
    public static void main(String[] args) {
        FinalArrayAfterKMul o= new FinalArrayAfterKMul();
        int[] nums = {100000,2000};
        int k = 2;
        int multipler = 1000000;
        o.getFinalState(nums, k, multipler);
    }
    public void getFinalState(int[] nums, int m, int multiplier) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        for (int  k= 0; k < m; k++) {
            PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x,y)->x.value - y.value);
            for (int i = 0; i < n; i++) {
                queue.add(new Pair(nums[i],i));
            } 
            Pair pair = queue.poll();
            int value = pair.value;
            int index = pair.index;
            value = value*multiplier;
            queue.add(new Pair(value,index));
            nums[index] =  (int)(((long)value*multiplier)%mod) ;

            while (!queue.isEmpty()) {
                Pair pair1 = queue.poll();
                System.out.println(pair1.value +"  "+ pair1.index);
            }

            System.out.println(" ------------------------------------- ");
        }
        
        System.out.println(Arrays.toString(nums));
    }
    class Pair{
        int value;
        int index;
        public Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
