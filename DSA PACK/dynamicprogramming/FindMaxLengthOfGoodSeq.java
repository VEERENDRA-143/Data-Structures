import java.util.ArrayList;
import java.util.List;

public class FindMaxLengthOfGoodSeq {
    public static void main(String[] args) {
        int[]  nums = { 1,2,3,4,5,1};
        int k= 0;
        goodSeq(nums, k);
    }
    public static void goodSeq(int[] nums,int k){
        List<List<Integer>>  ans= new ArrayList<>();
        genSubseq(0, nums, new ArrayList<>(), ans);
        System.out.println(ans);
        int count = 0;
        for (List<Integer> list : ans) {
            int flag = 0;
            int c =0;
            for (int i = 0; i < list.size()-2; i++) {

                if (list.get(i) != list.get(i+1)) {
                    if (c != k) {
                        flag=1;
                    }
                }
                else{
                    flag = 0;
                }
            }
            if (flag==1) {
                System.out.println(list.size());
                count++;
            }
            
        }
        System.out.println(count);
    }
    public static void genSubseq(int index,int[]  nums,List<Integer> subset ,List<List<Integer>> ans){
        if (index == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;

        }

        subset.add(nums[index]);
        genSubseq(index+1, nums, subset, ans);
        subset.remove(subset.size()-1);
        genSubseq(index+1, nums, subset, ans);
    }
}
