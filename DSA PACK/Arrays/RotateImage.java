import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];

        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                ans[rows][cols] = matrix[cols][rows];
                System.out.print(ans[rows][cols] + " ");
            }
        }
        System.out.println();
        for (int[] row : ans) {
            swap(row);
        }
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }

    }

    public static void swap(int[] arr){
        int i=0;
        int end = arr.length-1;
        while (i <= end) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end]= temp;
            i++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

}
