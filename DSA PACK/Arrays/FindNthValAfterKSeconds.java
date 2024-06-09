import java.util.Arrays;

public class FindNthValAfterKSeconds {
    public static void main(String[] args) {
        int n = 5;
        int k =1000;
        valueAfterKSeconds(n, k);
    }
    public static void valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int j = 0; j < k; j++) {
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i]+arr[i-1]) % 1000000007;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
