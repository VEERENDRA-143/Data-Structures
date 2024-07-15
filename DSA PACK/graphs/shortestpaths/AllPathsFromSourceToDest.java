import java.util.*;
public class AllPathsFromSourceToDest {
    public static void main(String[] args) {
        int[][] graph = {
            {4,3,1},
            {3,2,4},
            {3},
            {4},
            {},
        };
        allPathsSourceTarget(graph);
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int src = 0;
        int dest = n-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        f(src, dest, n, graph, ans, currPath);
        System.out.println(ans);
        return ans;
    }

    public static void f(int src,int dest,int n,int[][] graph,List<List<Integer>> ans, List<Integer> currPath){

        if (src == dest) {
            ans.add(new ArrayList<>(currPath));
            return;
        }

        int[] childs = graph[src];
        for (int node : childs) {
            currPath.add(node);
            f(node, dest, n, graph, ans, currPath);
            currPath.remove(currPath.size()-1);
        }

    }
}
