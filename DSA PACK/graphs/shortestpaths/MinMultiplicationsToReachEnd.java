// https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
import java.util.*;
public class MinMultiplicationsToReachEnd {
    public static void main(String[] args) {
        MinMultiplicationsToReachEnd ob = new MinMultiplicationsToReachEnd();
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;
        System.out.println(ob.minimumMultiplications(arr, start, end));
    }
    public int minimumMultiplications(int[] arr, int start, int end) {
        
        int mod = 100000;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        int[] distance = new int[100000];
        Arrays.fill(distance, (int)1e9);

        distance[start] = 0;

        while (!q.isEmpty()) {
            Pair pair  = q.peek();
            q.remove();
            int node = pair.node;
            int steps = pair.steps;

            for (int i = 0; i < arr.length; i++) {
                int num = (node * arr[i])%mod;
                if (steps + 1 < distance[num]) {
                    distance[num] = steps+1;
                    if (num == end) {
                        return steps+1;
                    }
                    q.add(new Pair(num, steps+1));
                }
            }
        }
        return -1;
    }
    class Pair{
        int node;
        int steps;
        Pair(int node,int steps){
            this.node = node;
            this.steps = steps;
        }
    }
}
