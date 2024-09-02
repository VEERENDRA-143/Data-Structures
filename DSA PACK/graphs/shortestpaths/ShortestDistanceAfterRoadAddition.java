import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceAfterRoadAddition {
    public static void main(String[] args) {
        ShortestDistanceAfterRoadAddition o = new ShortestDistanceAfterRoadAddition();
        int[][] quaries = {
            // {2, 4},
            {0,3},
            {0,2}
        };
        int src = 0;
        int n = 4;
        int dst = n-1;
        shortestDistanceAfterQueries(src, quaries, dst, n);
    }
    public static void shortestDistanceAfterQueries(int src, int[][] quaries,int destination,int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n-1; i++) {
            adj.get(i).add(i+1);
        }
        System.out.println(adj);

        int[] ans = new int[quaries.length];
        int i =0;
        for (int[] arr : quaries) {
            adj.get(arr[0]).add(arr[1]);
            System.out.println("Querry == >" + arr[0] + " -> " + arr[1]);
            ans[i++] =  DijkistrasAlgorithem(src, adj, destination, n);
        }
        System.out.println("Ans ==== "+Arrays.toString(ans));
    }
    public static int DijkistrasAlgorithem(int src, ArrayList<ArrayList<Integer>> adj,int destination,int n) {
       
        
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);

        q.add(0);
        distance[src] =0;

        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for (int item : adj.get(node)) {
                if (distance[node]+1 < distance[item]) {
                    distance[item]  = distance[node]+1 ;
                    q.add(item);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        return distance[destination];
    }
    
}
