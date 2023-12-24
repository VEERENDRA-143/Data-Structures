
import java.util.Arrays;

public class DivideArray {
    public static void main(String[] args) {
        int[] arr = { 1,3,3,2,7,3 };
       
        int[][] answer =  DivideArrayInTwo(arr, 2);
        for (int[] i : answer) {
            for (int j : i) {
                System.out.print(" "+j);
            }
            System.out.println(" ");
        }

    }

    private static int[][] DivideArrayInTwo(int[] arr, int k) {
        if (arr.length<9) {
            return new int[][]{};
        }
        int i = 0;
        Arrays.sort(arr);
        int[][] ans = new int[3][3];
        
        while (i <= arr.length - 1) {
            if (Check(arr, i, i + 3, k)) {
                    int j =i;
                    for (int m = 0; m < 3; m++) {
                        ans[(int) j / 3][m] = arr[j+m];
                    }
            }
            else{
                return new int[][]{{}};

            }
            i += 3;
        }
        return ans;
    }

    private static boolean Check(int[] arr, int start, int end, int k) {
        int flag = 0;
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (i != j) {
                    if (Math.abs(arr[i] - arr[j]) <= k) {
                        flag = 1;
                    }
                    else{
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
