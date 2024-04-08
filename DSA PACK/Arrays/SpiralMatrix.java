import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
            
        };
        brouteForce(matrix);
    }

    public static List<Integer> brouteForce(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = cols-1;

        int top = 0;
        int bootom = matrix.length-1;

        while (left<=right && top <= bootom) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bootom; i++) {
                System.out.print(matrix[i][right] + " ");
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bootom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bootom][i] + " ");
                    ans.add(matrix[bootom][i]);
                }
                bootom--;
            }
            
            if (left <= right) {
                for (int i = bootom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
    public static void spiralOrder(int[][] matrix) {
        
        
        
        
    }

    public static void printTopToBottom(int[][] matrix,int startCol){
        
        for (int j = 0; j < matrix.length; j++) {
            System.out.print(matrix[j][startCol]+" ");
        }
        System.out.println();
        
    }

    public static void printBottomToTop(int[][] matrix,int bootomRow){
        for (int i = matrix.length-1; i >= 0; i--) {
            System.out.print(matrix[i][bootomRow]+ " ");
        }
        System.out.println();
    }

    public static void printLeftToRight(int[][] matrix, int startRow){
        // int startIndex = 0;
        // int endIndex = matrix[startIndex].length-1;
        // while (startIndex <= endIndex) {
        //     System.out.println(matrix[startRow][startIndex]);
        //     startIndex++;
        // }
        for (int i = 0; i < matrix[startRow].length; i++) {
            System.out.print(matrix[startRow][i]+" ");
        }
        System.out.println();
    }

    public static void printRightToLeft(int[][] matrix, int startRow){
        for (int i = matrix[startRow].length-1 ; i >=0; i--) {
            System.out.print(matrix[startRow][i]+" ");
        }
        System.out.println();
    }
    
}
