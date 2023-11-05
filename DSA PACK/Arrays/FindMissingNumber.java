import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 7, 8 };
        missnumber(arr);
    }

    // Approch - 1
    static int missingnumber(int[] arr) {
        int n = arr.length + 1;
        int SumOfNaturalNumbers = n * (n + 1) / 2;
        int Array_Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Array_Sum += arr[i];
        }

        return SumOfNaturalNumbers - Array_Sum;
    }

    // Approch - 2

    static void missnumber(int[] arr){
        int[] temp = new int[8];
        for (int i = 1; i < arr.length; i++) {
            if(i==arr[i]){
                temp[i] = arr[i];
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
