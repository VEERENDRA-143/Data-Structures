
public class TriboniciiNumber {
    public static void main(String[] args) {
        int n = 0;
        tribonacci(n);
    }
    public static int tribonacci(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1] = 1;
        arr[2] = 1;
        
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
        }
    
        return arr[n];
    }
}
