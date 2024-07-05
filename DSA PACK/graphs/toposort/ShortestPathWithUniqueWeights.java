// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithUniqueWeights {
    public static void main(String[] args) {
        int[][] edges = {
            {0,1},
            {0,3},
            {3,4},
            {4,5},
            {5,6},
            {1,2},
            {2,6},
            {6,7},
            {7,8},
            {6,8}
        };
        int n = 9,m=10;
        shortestPath(edges, n, m, 0);
    }

    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);

        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int item: adj.get(node)) {
                if (distance[node] + 1 < distance[item]) {
                    distance[item] = distance[node] + 1;
                    queue.add(item);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] ==(int)1e9) {
                distance[i]=-1;
            }
        }
        return distance;
    }
}


