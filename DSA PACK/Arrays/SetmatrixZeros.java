import java.util.Arrays;

public class SetmatrixZeros {
    public static void main(String[] args) {
       int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
       };

       setZeroes(matrix);

    }
    public static void setZeroes(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (matrix[i][j]==0) {
                    for (int j2 = 0; j2 < ans[i].length; j2++) {
                        ans[i][j2] = 0;
                        ans[j2][i] = 0;
                    }
                }
                else{
                    ans[i][j] = matrix[i][j];
                }
            }
        }

        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
    }
}
