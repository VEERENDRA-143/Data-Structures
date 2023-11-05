public class OccurenceOfInteger {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 6, 2, 2, 2, 2, 9, 10,18};
        int n = 2;
        int ans = Times(arr, n);
        System.out.println(ans);
    }

    static int Times(int[] arr, int n) {

        // Find the max element
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        // New array to fing the frequency
        int[] frequency = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {

            frequency[arr[i]]++;
        }

        // Finding the Occcurence
        for (int i = 0; i < frequency.length; i++) {
            if (i == n) {
                return frequency[i];
            }
        }
        return -1;
    }
}