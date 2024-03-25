import java.util.Arrays;

public class FindMiniElem {
    public static void main(String[] args) {
        int[] arr1 = {1 ,3, 100};
        int[] arr2 ={4 ,3 ,1 ,5 ,2};
        int n=arr1.length;
        int m = arr2.length;
        System.out.println(minElements(n, m, arr1, arr2));
    }
     public static int minElements(int n, int m, int[] arr1, int[] arr2) {
        // code here
        int sum=0;
        for(int i=0;i<arr1.length;i++){
            sum+=arr1[i];
        }
        
        Arrays.sort(arr2);
        int count=0;
        int arrsum2=0;
        for (int i = 0; i < arr2.length; i++) {
            arrsum2+=arr2[i];
            count++;
            for (int j = i+1; j < arr2.length; j++) {
                arrsum2+=arr2[j];
                if (arrsum2<=sum) {
                    count++;
                }
                if (arrsum2==sum) {
                    return count-1;
                }
            }
            count=0;
        }
        return -1;
    }
}
