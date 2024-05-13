import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};
        findRelativeRanks(score);
    }

    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i:score){
            pq.offer(i);
        }

        Map<Integer, String> map = new HashMap<>();
        int index=1;
        while(!pq.isEmpty()){
            if(index==1){
                map.put(pq.remove(), "Gold Medal");
            } else if(index==2){
                map.put(pq.remove(), "Silver Medal");
            } else if(index==3){
                map.put(pq.remove(), "Bronze Medal");
            } else{
                map.put(pq.remove(), Integer.toString(index));
            }

            index++;
        }


        String[] res = new String[score.length];
        for(int i=0; i<res.length; i++){
            res[i] = map.get(score[i]);
        }
        return res;

    }
}
