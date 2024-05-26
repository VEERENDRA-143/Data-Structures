import java.util.Arrays;

public class DupXor {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3};
        System.out.println(duplicateNumbersXOR(nums));
    }
    public static int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int[] fre = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            fre[nums[i]]++;
        }
        int XOR = 0;
        for(int i = 0;i < fre.length;i++){
            if(fre[i] >= 2){
                XOR = XOR^i;
            }
        }
        return XOR;
    }
}
