public class CountFairPairs {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 7, 4, 4, 5 };
        int lower = 3;
        int upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
    }

    static long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }
}


// Approch - 2

// public long countFairPairs(int[] nums, int lower, int upper) {
//          Arrays.sort(nums);
//         long count = 0;
//         int u = nums.length-1;
//         int l = 1;
//         for(int i = 0; i<nums.length; i++){
//             while(u>0 && nums[i]+nums[u] > upper){
//                 u--;
//             }
//             l = i+1;
//             while(l<nums.length && nums[i]+nums[l] < lower){
//                 l++;
//             }
//             if(l<=u){
//                 count += u-l+1;
//             }
//         }
//         return count;
//     }