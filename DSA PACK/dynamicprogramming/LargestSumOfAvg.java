public class LargestSumOfAvg {
    public static void main(String[] args) {
        int[] nums = {9,1,2,3,9};
        int k = 3;
        largestSumOfAverages(nums, k);
    }
    public static void largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        // double ans = recursive(0,nums,k);
        // System.out.println(ans);
        double[][] dp  = new double[nums.length+1][k+1];
        System.out.println(dfs(nums, 0, k,dp));
    }
    private static double recursive(int index, int[] nums, int k) {
        if (k == 0) {
            return 0.0;
        }
        if (k == 1) {
            int sum = 0;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
            }
            return (double)(sum/(nums.length - index));
        }
        double sum = 0.0;
        double res = 0.0;
        for (int i = index; i <= nums.length- k; i++) {
            sum += nums[i];
            double avg = sum / (i-index+1);
            double tem = recursive(index+1, nums, k-1);
            res = Math.max(res,avg+tem);
        }
        return (double)res;
    }


    private static double dfs(int A[] ,int index,int K,double[][] dp){
        if(K==0){
            return 0.0;
        }
		//Returns the mean value of the entire array directly when k=1
        if (dp[index][K] != 0.0) {
            return dp[index][K];
        }
        if(K==1){
            int sum = 0;
            for(int i=index;i<A.length;i++){
                sum+=A[i];
            }
            dp[index][K] = (double)sum/(A.length-index);
            return dp[index][K];
        }

        double sum = 0.0;
        double res = 0.0;

        for(int i=index;i<=A.length-K;i++){
			// enumerate each separation point
            sum+=A[i];
            double avage = sum/(i-index+1);
			//next sub array mean
            dp[i+1][K-1] = dfs(A,i+1,K-1,dp);
			//find max
            res = Math.max(res, avage+dp[i+1][K-1]);

        }

        return dp[index][K] = (double)res;
    }
}
