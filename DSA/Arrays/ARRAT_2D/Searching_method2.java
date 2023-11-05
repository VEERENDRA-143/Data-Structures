import java.util.Arrays;

public class Searching_method2 {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr, 6)));
    }

    static int[] search(int[][] arr,int target){
        int row = arr.length;
        int col = arr[0].length;
        if(row==1){
            binarySearch(arr, 0, 0, col-1, target);
        }

        int rStart = 0;
        int rEnd = row-1;
        int cMid = col/2;
        while(rStart<=(rEnd-1)){
            int rMid = rStart +(rEnd- rStart)/2;
            if (arr[rMid][cMid]==target){
                return new int[]{rMid,cMid};
            }
            if (arr[rMid][cMid]<target) {
                rStart = rMid;
            }
            else{
                rEnd = rMid;
            }
        }
        
        if (arr[rStart+1][cMid]==target) {
            return new int[]{rStart+1,cMid};
        }

        // 1st half
        if(target<=arr[rStart][cMid-1]){
            binarySearch(arr, rStart, 0, cMid-1, target);
        }

        // 2nd half
        if (target>=arr[rStart][cMid+1] && target<=arr[rStart][col-1] ) {
            binarySearch(arr, rStart, cMid+1, col-1, target);
        }
        // 3rd half
        if (target <= arr[rStart+1][cMid-1]){
            binarySearch(arr, rStart+1, 0, cMid-1, target);
        }
        else{
          binarySearch(arr, rStart+1, cMid+1, col-1, target); 
        }

        return new int[]{-1,-1};
    }

    static int[] binarySearch(int[][] arr,int row,int colStart,int colEnd,int target){
        while(colStart<=colEnd){
            int mid = colStart +(colEnd-colStart)/2;
            if(arr[row][mid] == target){
                return new int[]{row,mid};
            }
            if(arr[row][mid]<target){
                colStart = mid+1;
            }
            else{
                colEnd = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
