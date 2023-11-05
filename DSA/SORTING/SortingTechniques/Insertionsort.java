package SortingTechniques;

import java.util.Arrays;

public class Insertionsort {
    // worst case = O(n^2)
    // Best case = O(n)
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2, -9, -4 };
        Insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Insertion_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
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