// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 0);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 3);


        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        
        // adj.get(1).add(2);
        // adj.get(2).add(3);
        // adj.get(3).add(4);
        // adj.get(3).add(7);
        // adj.get(4).add(5);
        // adj.get(5).add(6);
        // adj.get(7).add(5);
        // adj.get(8).add(9);
        // adj.get(9).add(10);
        // adj.get(10).add(8);

        System.out.println(isCyclic(V, adj));

    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisit = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean check = dfs(i,visited,pathVisit,adj);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(int node, boolean[] visited, boolean[] pathVisit, ArrayList<ArrayList<Integer>> adj) {
        

        visited[node] = true;
        pathVisit[node] = true;

        for (int item: adj.get(node)) {
            if (!visited[item]) {
                if(dfs(item, visited, pathVisit, adj)){
                    return true;
                }
            }
            else if (pathVisit[item]){
                return true;
            }
        }
        pathVisit[node] = false;
        return false;
    }
}
