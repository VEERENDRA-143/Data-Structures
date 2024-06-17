public class SumOfSquresofSpecialElements {
    public static void main(String[] args) {
        int[]  nums ={2,7,1,19,18,3};
        sumOfSquares(nums);
    }
    public static void sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
           if (n%i == 0) {
                ans += nums[i-1]*nums[i-1];
           }
        }
        System.out.println(ans);
    }
}
