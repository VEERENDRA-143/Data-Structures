// import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7};
        // leftrotate(arr);
        RightRotate(arr,3);
    }

    static void leftrotate(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == 0) {
                arr[i] = arr[arr.length - 1];
            }
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

        System.out.println(Arrays.toString(arr));
    }

    static void RightRotate(int[] arr,int k){
       reverse(arr,0,arr.length-1);
       reverse(arr, 0, k-1);
       reverse(arr, k, arr.length-1);

       System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start<=end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
