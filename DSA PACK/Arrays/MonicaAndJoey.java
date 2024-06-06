import java.util.Arrays;

public class MonicaAndJoey {
     
    public static void main(String[] args) {
        int N1 = 3;
        int M1 = 1;
        int K1 = 1;
        int[] V1 = {1, 1, 1};
        System.out.println(minMeals(N1, M1, K1, V1));  // Output: 1

        int N2 = 2;
        int M2 = 1;
        int K2 = 2;
        int[] V2 = {1, 4};
        System.out.println(minMeals(N2, M2, K2, V2));  // Output: -1
    }
    
    public static int minMeals(int N, int M, int K, int[] V) {
        // Sort the array to make it easier to find valid meals
        Arrays.sort(V);

        // Number of meals needed
        int meals = 0;

        // Start pointer for sliding window
        int start = 0;

        // Traverse the array using a sliding window
        while (start < N) {
            // Find the end of the current meal
            int end = start;

            // Extend the end pointer until the conditions are violated
            while (end < N && V[end] - V[start] <= M) {
                end++;
            }

            // Check if we have at least K items in the current meal
            if (end - start >= K) {
                // We have a valid meal, increment the meals count
                meals++;
                // Move the start pointer to the end of the current meal
                start = end;
            } else {
                // If we can't form a valid meal, return -1
                return -1;
            }
        }

        return meals;
    }

}
