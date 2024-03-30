public class SearchInTwoDMatrix {
    public static void main(String[] args) {
        int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target) {
                int start=0;
                int end = matrix[i].length-1;
                while (start<=end) {
                    int mid = (start+end)/2;
                    if (matrix[i][mid]==target) {
                        return true;
                    }
                    else if(matrix[i][mid]<target){
                        start = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
            }
        }
        return false;
    }
}
