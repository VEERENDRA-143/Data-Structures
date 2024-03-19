import java.util.Arrays;

public class MinimumNumberOfelements {
    public static void main(String[] args) {
        int n =3;
        int m = 5;
        
        int[] arr1={4, 2, 10, 9 ,7 ,6,1, 3};
        int[] arr2={9 ,7 ,1, 3, 5, 9, 7, 6, 1, 10};
        System.out.println(minElements(n, m, arr1, arr2));
    }
    public static int minElements(int n, int m, int[] arr1, int[] arr2) {
        int maxSum = 0;
        int firstSum=0;
        for (int i = 0; i < arr1.length; i++) {
            firstSum+=arr1[i];
        }
        System.out.println(firstSum);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        for (int i = arr2.length-1; i >=0 ; i--) {
            maxSum+=arr2[i];
            
            if (maxSum>firstSum) {
                System.out.println(maxSum);
                return Math.abs(arr2.length - i );
            }
            
        }
        
        return -1;
       
    }
}
