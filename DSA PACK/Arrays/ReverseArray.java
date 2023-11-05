import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr={2,4,1,7,9,10};
        Revrse_Array(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Revrse_Array(int[] arr){
        int start = 0;
        int end = arr.length-1;
        if(start == end){
            return;
        }
        while (start<end) {
            swap(arr,start,end);
            start = start+1;
            end = end-1;
        }
        
    }

    static void swap(int[] arr,int a, int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}