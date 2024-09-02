import java.util.Arrays;

public class CountQudraples {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6};
        countQuadruplets(nums);
    }
    public static int countQuadruplets(int[] nums) {
        int c=0;
        Arrays.sort(nums);
        int n= nums.length;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int left = j+1;
                int right =n-1;
                while(left<n && right<n){
                    int sum = nums[i]+nums[j]+nums[left];
                    if(sum == nums[right]){
                        c++;
                        left++;
                        right--;
                    }else if(sum < nums[right]) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        System.out.println(c);
        return c;
    }
}
