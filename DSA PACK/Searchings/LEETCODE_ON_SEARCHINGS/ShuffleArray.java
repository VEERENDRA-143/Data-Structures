import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n=3;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] ans= new int[nums.length];
        int[] left = SliceArray(nums,0,n);
        int[] right = SliceArray(nums,n,nums.length-1);

        return left;
    }

    static int[] SliceArray(int[] arr,int start,int end){
        int[] res = new int[end-start];
        for (int i =0;i<=end;i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
