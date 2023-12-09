
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InterSectionOfArrays {
    public static void main(String[] args) {
        int[] num1={1,2,2,1};
        int[] num2={2,2};
        System.out.println(Arrays.toString(INTERSECTION(num1, num2)));
    }

    static int[] INTERSECTION(int[] nums1,int[] nums2){
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        for(int i : nums1)
        {
            s1.add(i);
        }
        for(int i : nums2){
            if(s1.contains(i)) s2.add(i);
        }

        int[] res = new int[s2.size()];
        int i = 0;
        for(int n : s2)
        {
            res[i++] = n;
        }
        return res;
    }

    
}
