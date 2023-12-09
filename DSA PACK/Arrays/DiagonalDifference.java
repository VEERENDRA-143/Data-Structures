public class DiagonalDifference {
    public static void main(String[] args) {
        int[][] arr={
            {1,2,3},
            {4,5,6},
            {9,8,9}
        };
        System.out.println(FindDiagonalDifference(arr));
    }

    static int FindDiagonalDifference(int[][] arr){
        int ans;
        int leftdiagonal = 0;
        int rightdiagonal = 0;

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col <= arr[row].length-1; col++) {
                if (row==col) {
                    leftdiagonal+=arr[row][col];
                }
                if ((arr.length-1)-col ==row) {
                    rightdiagonal+=arr[row][col];
                }
            }
        }

        // for (int row = arr.length-1; row >=0 ; row--) {
        //     for (int col = arr.length-1; col >=0 ; col--) {
        //         if ((arr.length-1)-col ==row) {
        //             rightdiagonal+=arr[row][col];
        //         }
        //     }
        // }
        return Math.abs(rightdiagonal-leftdiagonal);
        
    }
}
