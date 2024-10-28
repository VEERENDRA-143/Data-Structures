import java.util.*;
public class CheckArraypairDivByK {
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        canArrange(ar, k);
    }   
    public static void canArrange(int[] arr, int k) {
        for (int i : arr) {
            System.out.print(i%k+ " ");
            System.out.println();
        }
    }
}

