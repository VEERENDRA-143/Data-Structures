
//  Sort the array of 0s, 1s, and 2s

import java.util.Arrays;

public class ArrangeZOT {
    public static void main(String[] args) {
        int[] arr={0,2,1,2,1,2,1,2,1,0,0};
        System.out.println(Arrays.toString(sortzot(arr)));
    }

    static int[] sortzot(int[] arr){
        int c0=0;
        int c1=0;
        int c2=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                c0++;
            }
            if (arr[i] == 1) {
                c1++;
            }
            if (arr[i] == 2) {
                c2++;
            }
        }

        int i =0;
        while (c0>0) {
            arr[i] = 0;
            i++;
            c0--;
        }

        while (c1>0) {
            arr[i] = 1;
            i++;
            c1--;
        }

        while (c2>0) {
            arr[i] = 2;
            i++;
            c2--;
        }

        return arr;
    }
}
