import java.util.Arrays;

public class KthSmallest {

    // This function returns the kth smallest element in an
    // array
    static int kth_Smallest(int[] arr, int n, int k) {
        // First, find the maximum element in the array
        int max_element = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max_element) {
                max_element = arr[i];
            }
        }

        // Create an array to store the frequency of each
        // element in the input array
        int[] freq = new int[max_element + 1];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // Keep track of the cumulative frequency of
        // elements in the input array
        int count = 0;
        for (int i = 0; i <= max_element; i++) {
            if (freq[i] != 0) {
                count += freq[i];
                if (count >= k) {
                    // If we have seen k or more elements,
                    // return the current element
                    return i;
                }
            }
        }
        return -1;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = { 12, 3, 5, 7, 19 };
        int n = arr.length;
        int k = 2;
        System.out.println("The " + k
                + "th smallest element is "
                + kth_Smallest(arr, n, k));
    }
}

// This code is contributed by akshitaguprzj3
