// https://leetcode.com/problems/path-with-maximum-probability/?envType=daily-question&envId=2024-08-27

import java.util.*;
public class PathWithMaxProbability {
    class Pair{
        int node;
        double probability;

        public Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }

    }
    public static void main(String[] args) {
        PathWithMaxProbability ob = new PathWithMaxProbability();
        int n = 3;
        int[][] edges = {
            {0,1},
            {1,2},
            {0,2}
        };
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;
        ob.maxProbability(n, edges, succProb, start, end);
    }

    public void maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        int ind= 0;
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], succProb[ind]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[ind]));
            ind++;
        }
        for (ArrayList<Pair> pList : adj) {
            for (Pair pair : pList) {
                System.out.println(pair.node +" = "+pair.probability);
            }
            System.out.println();
        }

        diskistras(adj, start_node, end_node, n);
    }
    public double diskistras( ArrayList<ArrayList<Pair>> adj, int start, int end,int n){
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((x,y)-> Double.compare(y.probability,x.probability));
        
        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        queue.add(new Pair(start,1d));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.node;
            double prob = p.probability;
           
            if (node == end) {
                System.out.println("max probabolity = " + maxProb[node]);
                System.out.println(Arrays.toString(maxProb));
                return maxProb[node];
            }

            for (Pair item : adj.get(node)) {
                int nextNode = item.node;
                double nextProb = item.probability;
                if (prob*nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = prob*nextProb;
                    queue.add(new Pair(nextNode,prob*nextProb));
                }
            }

        }
        
        return 0.0;

    }
    
}
