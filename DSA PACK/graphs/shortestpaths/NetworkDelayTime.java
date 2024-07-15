import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime ob  = new NetworkDelayTime();
        int[][] times = {
            {1,2,1}
            // {2,1,1},
            // {2,3,1},
            // {3,4,1}
        };
        int n = 2;
        int k = 2;
        System.out.println(ob.networkDelayTime(times, n, k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dis - y.dis);
        pq.add(new Pair(k, 0));

        int[] distance = new int[n+1];
        Arrays.fill(distance,(int)1e9);
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.peek();
            pq.remove();
            int node = pair.node;
            int dis  = pair.dis;

            for (Pair pairAdj : adj.get(node)) {
                int adjNode = pairAdj.node;
                int adjWe = pairAdj.dis;
                if (dis + adjWe < distance[adjNode]) {
                    distance[adjNode] = dis + adjWe;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        System.out.println(Arrays.toString(distance));
        int min = -1;
        for (int i = 1; i < distance.length; i++) {
            min = Math.max(min, distance[i]);
        }
        return min == (int)1e9 ? -1 : min;
        
    }
    class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
}
