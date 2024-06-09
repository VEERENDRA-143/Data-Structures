import java.util.Arrays;

public class MatrixSimilarity {
    public static void main(String[] args) {
        int[][] matrix  = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int k = 2;
        System.out.println(optimalSol(matrix, k));
    }
    public static void areSimilar(int[][] matrix , int k){
        
        int n = k%matrix[0].length;
        for (int is = 0; is < n; is++) {

            for (int i = 0; i < matrix.length; i++) {
                if (i%2  == 0 ) {
                    // Left Shift
                    int start = matrix[i][0];
                    for (int j = 0; j < matrix[i].length-1; j++) {
                        // System.out.print(matrix[i][j]);
                        matrix[i][j] = matrix[i][j+1];
                    }
                    matrix[i][matrix[i].length-1] = start;
                }
                else{
    
                    // Right Shift
                    int last = matrix[i][matrix[i].length-1];
                    for (int j = matrix[i].length-1; j >= 1; j--) {
                        matrix[i][j] = matrix[i][j-1];
                    }
                    matrix[i][0] = last;
                }       
            }
            
        }

        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
        
    }

    public static boolean optimalSol(int[][] matrix,int k){
        for (int[] l : matrix) {
            int n = l.length;
            for (int i = 0; i < n; ++i) {
                if (l[i] != l[(i + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
