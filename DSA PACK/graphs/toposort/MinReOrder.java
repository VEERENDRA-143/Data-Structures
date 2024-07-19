import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinReOrder {
    public static void main(String[] args) {
        
        int[][] connections = {
            {0,1},
            {1,3},
            {2,3},
            {4,0},
            {4,5}
        };
        int n =6;
        System.out.println(minReorder(n, connections));

    }
    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[0], 0));
        }
        return bfs(0, n, adj);
    }

     public static int bfs(int node, int n, Map<Integer, List<List<Integer>>> adj) {
        int c =0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        boolean[] visited = new boolean[n];
        visited[node] = true;
        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> li : adj.get(node)) {
                int neibhour = li.get(0);
                int sign = li.get(1);
                if (!visited[neibhour]) {
                    c += sign;
                    visited[neibhour] = true;
                    q.offer(neibhour);
                }
            }
        }
        return c;
     }

     public static int dfs(int node, int n, ArrayList<ArrayList<Integer>> adj,boolean[] visited) {
        int c =0 ;
        visited[node] = true;
        for (Integer to : adj.get(node)) {
            if (!visited[Math.abs(to)]) {
                c += dfs(Math.abs(to), n, adj, visited) + ((to>0)?1:0);
            }
        }
        return c;
     }
}
