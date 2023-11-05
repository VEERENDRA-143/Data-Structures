import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 8, 2, 9, 10, 34, 12, 34 };
        arr = mearge_sort(arr);
        System.out.println(Arrays.toString(arr));
        
    }

    static int[] mearge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr; 
        }
        int mid = arr.length / 2;

        int[] left = mearge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mearge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
                k++;
            } else {
                mix[k] = second[j];
                j++;
                k++;
            }
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

}
