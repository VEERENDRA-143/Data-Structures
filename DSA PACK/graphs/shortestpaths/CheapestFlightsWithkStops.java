// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithkStops {
    public static void main(String[] args) {

        CheapestFlightsWithkStops ob = new CheapestFlightsWithkStops();
        int n = 4;
        int[][] flights = {
            {0,1,100},
            {1,2,100},
            {2,0,100},
            {1,3,600},
            {2,3,200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(ob.findCheapestPrice(n, flights, src, dst, k));

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[src] = 0;


        while (!q.isEmpty()) {
            Tuple tuple = q.peek();
            q.poll();
            int stops = tuple.stops;
            int node = tuple.from;
            int cost = tuple.dis;
            if (stops > k) { 
                continue;
            }
            for (Pair pair : adj.get(node)) {
                int adjNode = pair.node;
                int adjWei = pair.weight;

                if (adjWei + cost < distance[adjNode]) {
                    distance[adjNode] = adjWei + cost ;
                    q.add(new Tuple(stops+1, adjNode, adjWei+cost));
                }
            }
        }

        if (distance[dst] == (int)1e9) {
            return -1;
        }
        return distance[dst];
    }
    class Pair{
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    class Tuple{
        int stops,from,dis;
        public Tuple( int stops,int from,int dis) {
            this.dis = dis;
            this.from = from;
            this.stops = stops;
        }
    }
}
