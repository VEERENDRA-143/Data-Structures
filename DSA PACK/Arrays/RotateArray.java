import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 7, 8 };
        leftrotate(arr);
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
}
