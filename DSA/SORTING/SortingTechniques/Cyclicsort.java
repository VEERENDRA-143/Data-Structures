package SortingTechniques;
import java.util.Arrays;

// Time Complexsity ========== Best case : O(n) =========
public class Cyclicsort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 1 };
        cyclic_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclic_sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp;
        temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
