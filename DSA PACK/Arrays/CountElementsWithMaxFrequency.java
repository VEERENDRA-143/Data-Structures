public class CountElementsWithMaxFrequency {
    public static void main(String[] args) {
        int[] nums = {14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77,14,50,86,23,59,95,32,68,5,41,77};
        System.out.println(maxFrequencyElements(nums));
    }
    public static int maxFrequencyElements(int[] nums) {
        int maxelement = FindMax(nums);
        int[] arr = new int[maxelement+1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int ans=0;
        int fre_max=FindMax(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==fre_max) {
                ans+=arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }
        
        return ans;
    }
    private static int FindMax(int[] nums) {
        int max=nums[0];
        for (int i : nums) {
            if (max<=i) {
                max=i;
            }
        }
        return max;
    }
}
