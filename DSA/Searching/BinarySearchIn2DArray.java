import java.util.Arrays;

public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 } 
                    };
        int[] ans = findAns(arr, 12);
        System.out.println("Element found at index: "
                + Arrays.toString(ans));
    }

    static int[] findAns(int[][] arr, int target) {
        int row = 0;
        int col = arr[row].length - 1;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[] { row, col };
            }

            // Target lies in further row
            if (arr[row][col] < target) {
                row++;
            }
            // Target lies in previous column
            else {
                col--;
            }
        }
        return new int[] { -1, -1 };
    }

}
