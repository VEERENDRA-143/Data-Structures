import java.util.ArrayList;
import java.util.Arrays;

public class BellManFordAlgorithem {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        bellman_ford(V, edges, S);
    }
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);
        distance[S] = 0;

        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> li: edges) {
                int u = li.get(0);
                int v = li.get(1);
                int we = li.get(2);

                if (distance[u] != (int)1e8 && distance[u] + we < distance[v]){
                    distance[v] = distance[u] + we;
                }

            }
        }
        
        for (ArrayList<Integer> li: edges) {
            int u = li.get(0);
            int v = li.get(1);
            int we = li.get(2);

            if (distance[u] != (int)1e8 && distance[u] + we < distance[v]){
                return new int[]{-1};
            }

        }
        System.out.println(Arrays.toString(distance));
        return distance;

    }
}
