import java.util.LinkedList;
import java.util.*;
public class BFSTraversal {
    
    // No of Vertices
    private int V;

    // Adjacency List
    public ArrayList<ArrayList<Integer>> adj;

    public BFSTraversal(int v){
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println(adj);
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void print(){
        System.out.println(adj);
    }

    public void BFS(int V,ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res.add(node);

            for (Integer It : adj.get(node)) {
                if (!visited[It]) {
                    visited[It] = true;
                    queue.add(It);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        graph.print();

        graph.BFS(5, graph.adj);
       

    }

}
