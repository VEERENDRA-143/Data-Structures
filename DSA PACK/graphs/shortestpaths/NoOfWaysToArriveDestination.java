import java.util.*;
public class NoOfWaysToArriveDestination {
    public static void main(String[] args) {
        NoOfWaysToArriveDestination ob = new NoOfWaysToArriveDestination();
        int[][] roads = {
            {0,6,7},
            {0,1,2},
            {1,2,3},
            {1,3,3},
            {6,3,3},
            {3,5,1},
            {6,5,1},
            {2,5,1},
            {0,4,5},
            {4,6,2}
        };
        int n= 7;
        System.out.println(ob.countPaths(n, roads));
    }
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        int[] distance = new int[n];
        int[] ways = new int[n];

        Arrays.fill(distance, (int)1e9);
        distance[0]= 0;
        ways[0] =1;

        while (!q.isEmpty()) {
            Pair pair = q.peek();
            q.remove();
            int node = pair.node;
            int dis = pair.dis;

           

            for (Pair pairr : adj.get(node)) {
                int adjNode = pairr.node;
                int adjWei = pairr.dis;
                if (dis + adjWei < distance[adjNode]) {
                    distance[adjNode] = dis +adjWei;
                    q.add(new Pair(adjNode, dis +adjWei));
                    ways[adjNode] = ways[node];
                }
                else if (dis + adjWei == distance[adjNode]) {
                    ways[adjNode] =( ways[node] + ways[adjNode])%mod; 
                }
            }
            
        }
        System.out.println(Arrays.toString(ways));
        return ways[n-1]%mod;

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
