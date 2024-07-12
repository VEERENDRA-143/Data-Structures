import java.util.*;
public class PrintShortestPath {

    public static void main(String[] args) {
        PrintShortestPath ob = new PrintShortestPath();
        int[][] edges = {
            {1,2,2},
            {2,5,5},
            {2,3,4},
            {1,4,1},
            {4,3,3},
            {3,5,1},
        };
        int n = 2, m= 1;
        int[] ans = ob.dijkistra(n, m, edges);
        System.out.println(Arrays.toString(ans));
    }

    public  int[] dijkistra(int n, int m, int edges[][]){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)1e9);
        int[] parents = new int[n+1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        dis[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance = y.distance);

        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.distance;
            
            for (Pair iter : adj.get(node)) {
                int edgNode = iter.node;
                int edgDis = iter.distance;
                if (edgDis + distance < dis[edgNode]) {
                    dis[edgNode] = edgDis + distance ;
                    pq.add(new Pair(edgNode, dis[edgNode]));
                    parents[edgNode] = node;
                    
                }
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        int node = n;
        while (parents[node] != node) {
            ls.add(node);
            node = parents[node];
        }   
        ls.add(1);
        System.out.println(ls);
        return parents;

    }
    
    class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
   
}