package SortingTechniques;
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 2, 5, 3, 9 };
        bubblesort(arr);
    }

    static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(arr[i]);
        }
    }
}