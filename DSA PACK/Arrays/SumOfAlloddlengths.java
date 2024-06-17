public class SumOfAlloddlengths {
    public static void main(String[] args) {
        int[]  arr = {1,4};
        sumOddLengthSubarrays(arr);
    }
    public static void sumOddLengthSubarrays(int[] arr) {
        int ans =0;
        
        int n = arr.length;
        
        int odds = n%2 == 0? n/2 : n/2+1;

        for (int i = 1; i <= odds; i++) {
            int windowSize =i + (i-1);
            int start = 0;
            int end  = start+windowSize;
            while (end <= n) {
                int sum = findSum(start, end, arr);
                ans+=sum;
                start++;
                end = start+windowSize;
            }
        }
    
        System.out.println(ans);
    }
    private static int findSum(int start,int end,int[] arr){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
