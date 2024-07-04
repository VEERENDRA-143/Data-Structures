import java.util.*;
public class AlieanDictnoary {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        int N = 5;
        int k = 4;
        String ans = findOrder(dict, N, k);
        System.out.println(ans);
    }   
    public static String findOrder(String [] dict, int N, int K){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N-2; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int min= Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < min; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }

        List<Integer> topo = toptSort(K, adj);
        System.out.println(topo);
        String ans = "";
        for (int ele : topo) {
            ans += (char)(ele + 'a');
        }
        return ans;
    }

    public static List<Integer> toptSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) {
                inDegree[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for (int item : adj.get(node)) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    q.add(item);
                }
            }
        }
        return topo;
    }
}
