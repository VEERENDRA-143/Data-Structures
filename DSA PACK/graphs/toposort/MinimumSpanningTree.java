import java.util.*;
public class MinimumSpanningTree {
    public static void main(String[] args) {
        
    }
    public int spanningTree(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->x.dis - y.dis);
        q.add(new Pair(0, 0));
        int[] visited = new int[V];
        int sum  = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int dist = pair.dis;

            if(visited[node] == 1) continue;

            visited[node] = 1;
            sum += dist;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int adjWe = adj.get(node).get(i).get(1);
                if (visited[adjNode] == 0) {
                    q.add(new Pair(adjNode, adjWe));
                }
            }
        }
        return sum;
    }
    class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node= node;
            this.dis = dis;
        }
    }
}
