import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KhansAlgorithem {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        bfs(adj, V);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj,int V){

        boolean[] visited = new boolean[V];

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) {
                inDegree[ele]++;
            }
        }



        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
       
        int[] topo = new int[V];
        int ind= 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            topo[ind++] = node;
            for (int item : adj.get(ind)) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    visited[item] = true;
                    q.add(item);
                }
            }
        }

        System.out.println(Arrays.toString(topo));
    }
}
