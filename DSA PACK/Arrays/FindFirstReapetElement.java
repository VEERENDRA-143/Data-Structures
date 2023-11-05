// Find the first repeating element in an array of integers

import java.util.HashSet;

public class FindFirstReapetElement {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 2, 2, 1, 3, 2, 1, 2, 4, 5 };

        printFirstRepeating(arr);

        int ans = FirstRepatedElement(arr);
        
        System.out.println(ans);

    }

    static int FirstRepatedElement(int[] arr) {
        int max = maxelement(arr);
        int[] Frequency = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            Frequency[arr[i]]++;
            if (Frequency[arr[i]] > 1) {
                return arr[i];
            }
        }
        return -1;
    }

    static int maxelement(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    // Approch - 2
    static void printFirstRepeating(int arr[]) {
        // Initialize index of first repeating element
        int min = -1;

        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;

            else // Else add element to hash set
                set.add(arr[i]);
        }

        // Print the result
        if (min != -1)
            System.out.println(
                    "The first repeating element is "
                            + arr[min]);
        else
            System.out.println(
                    "There are no repeating elements");
    }

}