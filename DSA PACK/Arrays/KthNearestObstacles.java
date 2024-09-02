import java.util.Arrays;
import java.util.PriorityQueue;

public class KthNearestObstacles {
    public static void main(String[] args) {
        int[][] queries = {
            {1,2},                 
            {3,4}, 
            {2,3}, 
            {-3,0}
        };
        int k = 2;
        resultsArray(queries, k);
    }
    public static void resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        int n = queries.length;
        int[] results = new int[n];
        int i = 1;
        
        for (int[] query : queries) {
            if (i < k) {
                results[i-1] = -1;
                pq.add(Math.abs(query[0]) + Math.abs(query[1]));
            }else{
                int dis = Math.abs(query[0]) + Math.abs(query[1]);
                pq.add(dis);
                if (pq.size() > k) {
                    pq.poll();
                }
                results[i-1] = pq.peek();
            }
            i++;
        }
        System.out.println(Arrays.toString(results));
    }
}
