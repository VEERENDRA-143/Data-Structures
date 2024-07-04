// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

import java.util.*;
public class ShortestPathInDAG {
   
    class Pair{
        int dest;
        int weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

    }
    public static void main(String[] args) {
        ShortestPathInDAG o = new ShortestPathInDAG();

        int[][] edges = {{0,1,2},{0,2,1}};
        int N = 4, M = 2;

        o.shortestPath(N, M, edges);
    }
    public  int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        for (int j = 0; j < M; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            adj.get(u).add(new Pair(v,wt));
        }

        boolean[] visited = new boolean[N];
        Stack<Integer> topo = new Stack<>();
        for (int k = 0; k < N; k++) {
            if (!visited[k]) {
                topoSort(k,visited,adj,topo);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;

        while (!topo.isEmpty()) {
            int node = topo.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).dest;
                int wt = adj.get(node).get(i).weight;

                if (distance[node] + wt < distance[v]) {
                    distance[v] = distance[node]+wt;
                }
            }
        }

        System.out.println(Arrays.toString(distance));
        return new int[]{};
	}
    private  void topoSort(int node, boolean[] visited, ArrayList<ArrayList<ShortestPathInDAG.Pair>> adj,Stack<Integer> topo) {
        visited[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v =adj.get(node).get(i).dest;
            if (!visited[v]) {
                topoSort(v, visited, adj, topo);
            }
        }
        topo.push(node);
    }
}
