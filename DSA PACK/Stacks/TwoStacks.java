import java.util.Arrays;
import java.util.Scanner;

public class TwoStacks {
    static int stacks(int x, int[] a, int[] b){
        return stacks(x,a,b,0,0);
    }

    static int stacks(int x,int[] a, int[] b, int sum,int counter){
        if (sum>x){
            return counter;
        }
        if (a.length ==0 || b.length==0){
            return counter;
        }

        int left = stacks(x, Arrays.copyOfRange(a,1,a.length),b,sum+a[0],counter++);
        int right = stacks(x, a,Arrays.copyOfRange(b,1,b.length),sum+b[0],counter++);

        return  Math.max(left,right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {

            int a_l = scan.nextInt();
            int b_l = scan.nextInt();
            int x = scan.nextInt();

            int[] a = new int[a_l];
            int[] b = new int[b_l];
            for (int j = 0; j < a_l; j++) {
                a[j] = scan.nextInt();
            }

            for (int j = 0; j < b_l; j++) {
                b[j] = scan.nextInt();
            }

            System.out.println(stacks(x,a,b));

        }
    }
}
