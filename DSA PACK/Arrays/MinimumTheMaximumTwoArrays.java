import java.util.Arrays;

public class MinimumTheMaximumTwoArrays {
    public static void main(String[] args) {
        int divisor1=3;
        int divisor2=5;
        int uniqueCnt1=2;
        int uniqueCnt2=1;
        minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2);
    }
    public static void minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int[] arr1 = new int[uniqueCnt1];
        int[] arr2 = new int[uniqueCnt2];

        int start =1 ;
        int index=0;
        while (index != uniqueCnt1) {
            if (start%divisor1 !=0) {
                arr1[index++] = start;
            }
            start++;
        }

        int start2=2;
        index=0;
        while (index != uniqueCnt2) {
            if (start2 % divisor2 !=0) {
                arr2[index++] = start2;
            }
            start2++;
        }



        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
