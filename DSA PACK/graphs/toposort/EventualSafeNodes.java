// https://leetcode.com/problems/find-eventual-safe-states/description/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeNodes {

    public static void main(String[] args) {
        int[][] graph= {
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {},
        };
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        int[] check = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, pathVisited, check, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        System.out.println(Arrays.toString(check));
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean dfs(int node,boolean[] visited,boolean[] pathVisited,int[] check,int[][] graph){
        visited[node] = true;
        pathVisited[node] = true;
        check[node] = 0;

        for (int item : graph[node]) {
            if (!visited[item]) {
                if(dfs(item, visited, pathVisited, check, graph)){
                    return true;
                }
            }else if (pathVisited[item]) {
                return true;
            }
        }
        pathVisited[node] = false;
        check[node] = 1;
        return false;
    }
    
}