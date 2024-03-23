public class FindMaxConcicutiveNums {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                count++;
            }
            else{
                maxLen = (int)Math.max(count,maxLen);
                count = 0;
            }
        }
        maxLen = (int)Math.max(count,maxLen);
        return maxLen;
    }
}
