import java.util.*;
public class GoodSubArrays {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {4,2,3,2,1};
        countoddSubarrays(n, arr);
    }
    public static void countoddSubarrays(int n, int[] arr) {
        
        int[][] prefix = new int[n][n];

        for (int i = 0; i <n; i++) {
            prefix[i][i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j > i; j--) {
                // prefix[i-1][j-1] = prefix[i-1][j-2] ^ prefix[i+1][j-1];
                System.out.print("("+ (i) + ","+j+")  ");
            }
            System.out.println();
        }

        for (int[] is : prefix) {
            System.out.println(Arrays.toString(is));
        }
        
    }
}
