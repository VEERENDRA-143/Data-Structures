import java.util.Arrays;

public class MakeTwoArraysEqually {
    public static void main(String[] args) {
        int[] target = {3,7,9};
        int[] arr={3,7,11};
        boolean ans = twoarrays(target, arr);
        System.out.println(ans);
    }

    static boolean twoarrays(int[] target,int[] arr){
        Arrays.sort(target);
        Arrays.sort(arr);
        int i=0;
        while (i<target.length) {
            if (target[i] ==arr[i]) {
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
