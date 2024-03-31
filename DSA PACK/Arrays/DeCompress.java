import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeCompress {
    public static void main(String[] args) {
        int[] nums={1,1,2,3};
        decompressRLElist(nums);
    }
    public static int[] decompressRLElist(int[] nums) {
        int len=0;
        if (nums.length%2==0) {
            len = nums.length;
        }
        else{
            len = nums.length-1;
        }
        int first = 0;
        int second = 1;
        
        List<Integer> ans = new ArrayList<>();
        while (second < len) {
            int fre = nums[first];
            int val = nums[second];
            for (int i = 0; i < fre; i++) {
                ans.add(val);
            }
            first = second+1;
            second = second+2;
        }
        int[] arr = new int[ans.size()];
        int index=0;
        for (int i : ans) {
            arr[index++]=i;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
