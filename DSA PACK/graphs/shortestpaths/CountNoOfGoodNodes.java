
import java.util.*;
public class CountNoOfGoodNodes {
    static public int sum;
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},{1,2},{2,3},{3,4},{0,5},{1,6},{2,7},{3,8}
            };
        countGoodNodes(edges);
    }
    public static int countGoodNodes(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(adj);
        boolean[] visited = new boolean[n+1];
        sum = 0;
        dfs(0, adj, visited);
        System.out.println(sum);
        return 0;
    }

    public static int dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited) {
        visited[node] = true;

        if (node != 0 && adj.get(node).size() == 1) {
            sum++;
            return 1;
        }
        
        int size = 0,total = 1;
        boolean valid = true;
        for (int item : adj.get(node)) {
            
            if (!visited[item]) {
                int child = dfs(item, adj, visited);
                total+=child;
                if (size == 0) {
                    size = child;
                }else if (size != child) {
                    valid = false;
                }
            }
        }
        if (valid) {
            sum++;
        }
        return total;
    }
}
