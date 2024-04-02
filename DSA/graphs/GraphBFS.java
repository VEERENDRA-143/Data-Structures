import java.io.*;
import java.util.*;
public class GraphBFS {
    
    // No of Vertices
    private int V;

    // Adjacency List
    private LinkedList<Integer> adj[];

     public GraphBFS(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // To add Edge to graph
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    public void BFS(int start){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        while (queue.size()!=0) {
            start = queue.poll();
            System.out.print(start+" ");
            Iterator<Integer> adjacents = adj[start].listIterator();
            while (adjacents.hasNext()) {
                int current = adjacents.next();
                if (!visited[current]) {
                    visited[current] = true;
                    queue.add(current);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFS(2);

    }
}
