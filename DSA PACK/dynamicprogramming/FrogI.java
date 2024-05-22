// https://atcoder.jp/contests/dp/tasks/dp_a
// There is a frog on the '1st' step of an 'N' stairs long staircase.
// The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.
// If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
// If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
// Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.


// =======================  EXAMPLE   ===========================
// If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 
// 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.

// n = 4
// heights  = [10, 20, 30, 10]
// Output = 20



public class FrogI {
    public static void main(String[] args) {
        int[] heights = {10 ,50 ,10};
        int n = heights.length;

        System.out.println(recursiveMethod(n-1, heights));

        System.out.println(findMin(n, heights));
    }

    // Recursion Method ===>>> TC = O(N * 2^N)
    public static int recursiveMethod(int n ,int[] heights){
        if (n== 0) {
            return 0;
        }
        int fs = recursiveMethod(n-1, heights)+Math.abs(heights[n]-heights[n-1]);
        int ss = Integer.MAX_VALUE;
        if (n>1) {
            ss = recursiveMethod(n-2, heights)+Math.abs(heights[n]-heights[n-2]);
        }
        return Math.min(fs, ss);
    }

    // ================ OPTIMIZATION DP =======================


    // Dynamic Programming -> Memoization 
    // === TC =========>>>>>> O(N)
    // ====SC =========>>>>>> O(N)

    public static int findMin(int n ,int[] heights){
        int[] dp =new int[n];
        dp[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int firstStep = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int secondeStep  = Integer.MAX_VALUE;
            if (i > 1) {
                secondeStep = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i] = Math.min(firstStep, secondeStep);
        }
        return dp[n-1];
    }
    
}

