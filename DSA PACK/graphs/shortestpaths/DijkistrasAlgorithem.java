import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkistrasAlgorithem {

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int src = 0; 
        int N = 10;
    }

    public int[] dijkistra(int src,ArrayList<ArrayList<ArrayList<Integer>>> adj,int V){

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance - y.distance);
        int[] dis = new int[V];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        pq.add(new Pair(0, src));
        while (pq.size() != 0) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int edgeNode = adj.get(node).get(i).get(0);

                if (edgeWeight + distance < dis[edgeNode]) {
                    dis[edgeNode] = edgeWeight + distance;
                    pq.add(new Pair(dis[edgeNode], edgeNode));
                }
            }
        }
        return dis;
    }   
}


class Pair
{
    int distance;
    int node;
    
    Pair(int distance, int node)
    {
        this.distance=distance;
        this.node= node;
    }
}



// class Solution
// {
//     //Function to find the shortest distance of all the vertices
//     //from the source vertex S.
//     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
//     {
//         // Write your code here
        
//         PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)-> x.distance-y.distance);
//         int dis[]= new int[V];
//         for(int x=0;x<V;x++)
//             dis[x]=Integer.MAX_VALUE;
//         dis[S]=0;
        
//         pq.add(new Pair(0,S));
//         while(!pq.isEmpty())
//         {
//             Pair p= pq.poll();
//             int d= p.distance;
            
//             for(int x=0;x<adj.get(p.node).size();x++)
//             {
//                 int edge_n= adj.get(p.node).get(x).get(0);
//                 int edge_d= adj.get(p.node).get(x).get(1);
//                 if(edge_d+d < dis[edge_n])
//                 {
//                     dis[edge_n]=edge_d + d;
//                     pq.add(new Pair(dis[edge_n], edge_n));
//                 }
//             }
            
//         }
//         return dis;
        
//     }
// }