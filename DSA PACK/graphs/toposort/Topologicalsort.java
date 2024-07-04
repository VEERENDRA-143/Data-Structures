// problem  :  https://www.geeksforgeeks.org/problems/topological-sort/1

// descrpition :  https://www.geeksforgeeks.org/topological-sorting/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Topologicalsort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println(topoSort(V, adj));
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }
        int[] ans = new int[V];
        int ind=0;
        while (!stack.isEmpty()) {
            ans[ind] = stack.pop();
            ind++;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[node] =true;
        for (int item : adj.get(node)) {
            if (!visited[item]) {
                dfs(item, visited, adj, stack);
            }
        }
        stack.push(node);
    }
}
