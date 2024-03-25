import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3};
        System.out.println("Duplicated Elements are: ");
        Duplictes(arr);
    }
    public static List<Integer> Duplictes(int[] arr){
        List<Integer> ans = new ArrayList<>();
        if (arr.length==0) {
            return ans;
        }
        if (arr.length==1) {
            ans.add(arr[0]);
            return ans;
        }
        int max = maxelement(arr);
        int[] count = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        int j=0;
        for (int i = 0; i < count.length; i++) {
            // System.out.println(count[i]);
            if (count[i]==1) {
                arr[j]=i;
                ans.add(i);
                j++;
                System.out.println(i);
            }
            if (count[i]>=2) {
                // System.out.println();
                arr[j++]=i;
                arr[j++] = i;
                ans.add(i);
                ans.add(i);
                System.out.println(i);
                System.out.println(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" -> ");
        }

        // for (int i = 0; i < count.length; i++) {
        //     if (count[i]<=2 && count[i]>=1) {
        //         ans.add(i);
        //         System.out.println(i);
        //     }
        // }
        
        return ans;
    }

    static int maxelement(int[] arr){
        int max=0;
        for (int i : arr) {
            if (i>max) {
                max=i;
            }
        }
        return max;
    }
}
