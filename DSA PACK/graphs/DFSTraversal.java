
import java.util.ArrayList;

public class DFSTraversal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(3);
        adj.get(2).add(6);
        adj.get(3).add(3);
        adj.get(3).add(7);
        adj.get(6).add(2);
        adj.get(6).add(7);
        adj.get(7).add(6);
        adj.get(7).add(3);
        

        boolean[] visited = new boolean[8];
        ArrayList<Integer> ans = new ArrayList<>();

        dfsTraversal(0, adj, visited, ans);
        System.out.println(ans);
    }
    public static void dfsTraversal(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfsTraversal(it, adj, visited, ans);
            }
        }

    }
}
