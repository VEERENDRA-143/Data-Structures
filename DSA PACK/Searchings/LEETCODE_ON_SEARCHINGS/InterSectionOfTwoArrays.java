import java.util.ArrayList;
import java.util.Arrays;

public class InterSectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans = intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        // int len_num1= nums1.length;
        // int len_num2= nums2.length;
        int ans[]= InterSection(nums1,nums2);
        int unique[] = FindUniue(ans);
        return unique;
        
    }

    static int[] InterSection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]) {
                    list.add(nums1[i]);
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }


    static int[] FindUniue(int[] arr){
        int len = arr.length;   
          
        int[] distinctArray = new int[20];  
        int index = 0;  
        for (int i = 0; i < len; i++)   
        {   
            int flag = 0;  
            for (int j = 0; j < i; j++){  
                if (arr[i] == arr[j]){   
                    flag = 1;  
                    break;   
                }  
            }  
           if (flag == 0){   
                distinctArray[index] = arr[i];  
                index++;    //increment index value  
            }  
        }  
        return distinctArray;
    }
    
}
