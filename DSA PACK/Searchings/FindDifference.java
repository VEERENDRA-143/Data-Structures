import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDifference {
    public static void main(String[] args) {
       int[] nums1 = {1,2,3};
       int[] nums2 = {2,4,6};

       System.out.println(findDifference(nums1,nums2));
    }

    static List<List<Integer>> findDifference(int[] num1,int[] num2){
        List<List<Integer>> ans = new ArrayList<>();
        int[] l1 = INTERSECTION(num2, num1);
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i : l1) {
            list1.add(i);
        }
        ans.add(list1);
        int[] l2 = INTERSECTION(num1, num2);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : l2) {
            list2.add(i);
        }
        ans.add(list2);
        return ans;
    }

    static int[] INTERSECTION(int[] nums1,int[] nums2){
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        for(int i : nums1)
        {
            s1.add(i);
        }
        for(int i : nums2){
            if(!s1.contains(i)) s2.add(i);
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
