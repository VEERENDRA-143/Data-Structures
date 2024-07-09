import java.lang.reflect.Array;
import java.util.Arrays;

public class ArcheryCompitation {

    int bobPoints =0;
    int[] bobArray = new int[12];

    public static void main(String[] args) {
        int numArrows = 9;
        int[] aliceArrows = {1,1,0,1,0,0,2,1,0,1,2,0};
        ArcheryCompitation o = new ArcheryCompitation();
        System.out.println(o.maximumBobPoints(numArrows, aliceArrows));
    }
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] B = new int[12];
        f(11, numArrows, 0, aliceArrows, B);
        System.out.println(Arrays.toString(bobArray));
        return bobArray;
    }
    public void f(int ind,int arrows,int max,int[] A,int[] B){

        if (ind < 0 || arrows <= 0) {
            if (arrows > 0) {
                B[0] += arrows;
            }
            if (max > bobPoints) {
                bobPoints = max;
                bobArray= B.clone();
            }
            return;
        }

        if(arrows >= A[ind]+1){
            B[ind] = A[ind] +1;
            f(ind-1, arrows - B[ind], max + ind, A, B);
            B[ind] = 0;
        }

        f(ind-1, arrows, max, A, B);
        B[ind] = 0;
    }
}
