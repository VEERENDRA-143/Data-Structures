import java.util.Arrays;

public class Search2D {

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int target = 8;
        System.out.println(Arrays.toString(SearchEle2D(arr, target)));
    }

    static int[] SearchEle2D(int arr[][], int target){
       
        int row = 0;
        int col = arr[row].length-1;
        while (row<=col) {
            int last_ele = arr[row][col];
            System.out.println("col = "+ col);
            if (target<arr[row][col]) {
                col--;
            }
            else if (target==arr[row][col]) {
                return new int[] {row,col};
            }
            else{
                row++;
                col = arr[row].length-1;
            }
        }
        return new int[] {-1,-1}; 
    }
    
}