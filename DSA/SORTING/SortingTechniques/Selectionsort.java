package SortingTechniques;
import java.util.Arrays;
// Time complexsity
// ===========::::======= best case = worst case = O(n^2) ========:::=======
public class Selectionsort {
    public static void main(String[] args) {
        int[] arr={3,1,5,4,2,-9,-4};
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // finding
            int last = arr.length - i - 1;
            int maxindex = getmaxelement(arr, 0, last);
            swap(arr, maxindex, last);
        }
    }

    static int getmaxelement(int[] arr, int start, int end) {
        int max=  start;
        for (int i = start; i < end; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
    static void swap(int[] arr,int first,int second){
        int temp;
        temp=arr[first];
        arr[first] = arr[second];
        arr[second] =temp;
    }
}