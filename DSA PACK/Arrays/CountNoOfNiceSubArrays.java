public class CountNoOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int  k =  2;
        System.out.println(numberOfSubarrays2(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int subarrays = 0, initialGap = 0, qsize = 0, start = 0;
        for (int end = 0; end < nums.length; end++) {
            // If current element is odd, increment qsize by 1.
            if (nums[end] % 2 == 1) {
                qsize++;
            }
            // If qsize is k, calculate initialGap and add it in the answer.
            if (qsize == k) {
                initialGap = 0;
                // Calculate the number of even elements in the beginning of
                // subarray.
                while (qsize == k) {
                    qsize -= nums[start] % 2;
                    initialGap++;
                    start++;
                }
            }
            subarrays += initialGap;
        }
        return subarrays;
    }

    public static int numberOfSubarrays2(int[] nums, int k) {
        int count=0;
        int start = 0;
        int countEachsubArrayOdds=0;
        int sizeOfsubArray = 0;
        for(int end = 0;end < nums.length;end++){
            if(nums[end]%2 == 1){
                countEachsubArrayOdds++;
            }

            if(countEachsubArrayOdds == k){
                sizeOfsubArray = 0;
                while(countEachsubArrayOdds == k){
                    countEachsubArrayOdds -= nums[start]%2;
                    sizeOfsubArray++;
                    start++;
                }
            }
            count += sizeOfsubArray;
        }
        return count;
    }

}
