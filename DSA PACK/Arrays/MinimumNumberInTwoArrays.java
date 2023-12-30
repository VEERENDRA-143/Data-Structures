
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumNumberInTwoArrays {
    public static void main(String[] args) {
        int[] num1 = {4,1,3};
        int[] num2 = {5,7};
        Minimum(num1, num2);
    }

    static void Minimum(int[] arr1,int[] arr2){
        
        int minim = Listmin(arr1, arr2);
        System.out.println(minim);

    }

    private static int Listmin(int[]num1,int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : num1) {
            for (int j : num2) {
                if (i==j) {
                    list.add(i);
                }
            }
        }

        if (list.size()>0) {
            return list.get(0);
        }
        return Math.min(num1[0]*10+num2[0],num2[0]*10+num1[0]);
    }
}
