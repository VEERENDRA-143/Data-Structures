import java.util.ArrayList;

public class SubArraySium {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = { 1,2};
        int n = arr.length;
        int s = 1;
        subarraySum(arr, n, s);
    }

    public static void subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            for (int j = i + 1; j < n; j++) {
                
                if (sum == s) {
                    ans.add(i+1);
                    ans.add(j);
                    System.out.print(ans);
                    return;
                }
                sum += arr[j];
            }
            sum = 0;
        }
        System.out.print(ans);
        return;
    }

}