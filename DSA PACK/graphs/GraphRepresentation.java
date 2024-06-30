import java.util.ArrayList;
import java.util.Arrays;

public class GraphRepresentation {

    public static void main(String[] args) {
        int N=3;
        matrixRepresentation(N);
        adjacencyListRepresentation(N);
    }

    public static void matrixRepresentation(int N){

        int[][] graph = new int[N+1][N+1];

        graph[1][2] =1;
        graph[2][1] =1;

        graph[2][3] = 1;
        graph[3][2] = 1;

        graph[1][3] = 1;
        graph[3][1] = 1;

        for (int[] is : graph) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static void adjacencyListRepresentation(int N){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }

        // u----v
        // adj.get(u).add(v);
        // adj.get(v).add(u);

        // 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 2----3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(adj);
    }

    public static void weightedGraph(int N){
       
    }
}