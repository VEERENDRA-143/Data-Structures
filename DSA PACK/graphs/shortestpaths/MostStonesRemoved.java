import java.util.*;
public class MostStonesRemoved {
    public static void main(String[] args) {
        int[][] stones = {
            {0,0},
            // {0,1},
            // {1,0},
            // {1,2},
            // {2,1},
            // {2,2}
        };
        removeStones(stones);
    }
    public static void removeStones(int[][] stones) {

        int n = stones.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj,visited,i);
                c++;
            }
        }
        System.out.println(n - c);

    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited,int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int edgNode : adj.get(node)) {
            if (!visited[edgNode]) {
                dfs(adj, visited, edgNode);
            }
            
        }
    }
}
