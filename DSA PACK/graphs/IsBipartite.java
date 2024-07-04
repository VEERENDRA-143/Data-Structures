import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public static void main(String[] args) {
        int[][] graph = {
            {1,3},
            {0,2},
            {1,3},
            {0,2}
        };
        // [[1,3],[0,2],[1,3],[0,2]]
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] fillColors = new int[n];
        Arrays.fill(fillColors, -1);

        for (int i = 0; i < n; i++) {
            if (fillColors[i] == -1) {
               boolean check = bfs(i,0,fillColors,graph);
               if (!check) {
                    return false;
               }
            }
        }

        return true;
    }
    private static boolean dfs(int node, int col, int[] fillColors, int[][] graph) {
        fillColors[node] = col;
        for (int item : graph[node]) {
            if (fillColors[item] == -1) {
                if (!dfs(item, 1-col, fillColors, graph)) {
                    return false;
                }
            }else if (fillColors[item] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean bfs(int node,int col,int[] fillColors,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        fillColors[node] = 0;
        while (!q.isEmpty()) {
            int item = q.poll();

            for (int ele : graph[node]) {
                if (fillColors[ele] == -1) {
                    fillColors[item] = 1 - fillColors[node];
                    q.add(ele);
                }
                else if (fillColors[item] == fillColors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
