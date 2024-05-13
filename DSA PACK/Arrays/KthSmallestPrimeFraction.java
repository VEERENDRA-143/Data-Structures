import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        kthSmallestPrimeFraction(arr, k);
    }
    public static void kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));
        int N = arr.length;
        
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                minHeap.offer(new int[]{arr[i], arr[j]});
            }
        }
        
        int[] result = null;
        for (int i = 0; i < k; ++i) {
            result = minHeap.poll();
        }
        
        System.out.println(result);
    }
}
