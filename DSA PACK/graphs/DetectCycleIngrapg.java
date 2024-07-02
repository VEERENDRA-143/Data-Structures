// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  
 */
class  Pair {

    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second =second;
    }
}
public class DetectCycleIngrapg {
    public static void main(String[] args) {
        int V= 4;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // adj.get(0).add(1);

        // adj.get(1).add(0);
        adj.get(1).add(2);
        // adj.get(1).add(4);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        // adj.get(3).add(4);

        // adj.get(4).add(1);
        // adj.get(4).add(3);
        System.out.println(adj);
        System.out.println(isCycle(V, adj));
        
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean res = DFS(i, visited, adj, -1);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForCycleBFS(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean[] visited){

        visited[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        while (!queue.isEmpty()) {
            int node  = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();
            for (int adjCentNode : adj.get(node)) {
                if (!visited[node]) {
                    visited[adjCentNode] = true;
                    queue.add(new Pair(adjCentNode,node));
                }else if (parent != adjCentNode) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean DFS(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int parent){
        visited[node] = true;
        for (int item : adj.get(node)) {
            if (!visited[item]) {
                boolean ans = DFS(item, visited, adj, node);
                if (ans) {
                    return true;
                }
            }else if (item != parent) {
                return true;
            }
        }
        return false;
    }

}
