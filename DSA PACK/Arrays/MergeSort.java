import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 6, 1, 7, 9, 10, 34, 12 };
        arr = merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {

        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[i]) {
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
