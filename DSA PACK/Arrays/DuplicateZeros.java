import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr={9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
        duplicateZeros(arr);
    }
    public static void duplicateZeros(int[] arr) {
        int i=0;

        while (i <= arr.length-1) {

            if (arr[i] == 0 ) {
                for (int j = arr.length-1; j > i+1; j--) {
                    arr[j]  = arr[j-1];
                }
                if(i<arr.length-1){
                    i++;
                }
                arr[i]=arr[i-1];
            }
            i++;
        }

        System.out.println(Arrays.toString(arr));

    }
}
