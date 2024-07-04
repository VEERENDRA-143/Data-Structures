import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestCycleIngraph {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
            {0,1},
            {1,2},
            {2,0},
            {3,4},
            {4,5},
            {5,6},
            {6,3},
        };
        System.out.println(findShortestCycle(n, edges));
    }
    public static int findShortestCycle(int n, int[][] edges) {
        int ans= Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            int[] dis = new int[n];
            Arrays.fill(dis,(int)1e9);

            int[] parent = new int[n];
            Arrays.fill(parent,-1);

            dis[i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            
            while(!q.isEmpty()){

                int x = q.poll();
               
                for (int child : edges[x]){

                    if (dis[child] == (int) (1e9)){
 
                        // Increase distance by 1
                        dis[child] = 1 + dis[x];
 
                        // Change parent
                        parent[child] = x;
 
                        // Push into the queue
                        q.add(child);

                    }else if (parent[x] != child && parent[child] != x){
                        ans = Math.min(ans, dis[x] + dis[child] + 1);
                    }
                }
            }
        }


        return ans == Integer.MAX_VALUE ? -1:ans;
    }
}
