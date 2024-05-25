
import java.util.ArrayList;
import java.util.Collections;

public class MatrixIII {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };
        findReslust(matrix);
    }
    public static void findReslust(int[][] matrix){
        int evenCount = 0;
        int oddCount =0;
        for (int[] row : matrix) {
            for (Integer ele : row) {
                if (ele %2 == 0) {
                    evenCount++;
                }else{
                    oddCount++;
                }
            }
        }

        System.out.println(evenCount+" "+oddCount);
        if (evenCount < oddCount) {
            Rotatematrix(matrix);
        }else{
            TransPoseOfmatrix(matrix);
        }

    }

    private static void Rotatematrix(int[][] matrix){
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> row= new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                row.add(matrix[j][i]*2);
            }
            Collections.reverse(row);
            ans.add(row);
        }
        for (ArrayList<Integer> arrayList : ans) {
            System.out.println(arrayList);
        }
    }

    // Interchanging rows to colums or vice versa is called transpose
    private static void TransPoseOfmatrix(int[][] matrix){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> row= new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                row.add(matrix[j][i]+1);
            }
            ans.add(row);
        }
        for (ArrayList<Integer> arrayList : ans) {
            System.out.println(arrayList);
        }
    }
}
