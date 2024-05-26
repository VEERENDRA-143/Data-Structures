import java.util.Arrays;

public class FindOccrenceOfElemeits {
    
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,3,1,3,1};
        int[] queries = {5,6,1,5,6,4,1,5};
        int x = 3;
        occurrencesOfElement(nums, queries, x);
    }
    public static void occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int occ = findOccrence(queries[i],nums,x);
            ans[i] = occ;
        }
        System.out.println(Arrays.toString(ans));
    }
    private static int findOccrence(int queery, int[] nums, int x) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (x == nums[j]) {
                count++;
                if (count == queery) {
                    return j;
                }
            }

        }
        return -1;
    }

    public static void fO(int[] nums, int[] queries, int x){
        // Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                count++;
            }
        }
        int[] ans = new int[queries.length];
        int ind = 0;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] <= count) {
                ans[i] = i;
            }
            else{
                ans[i] = -1;
            }
            ind++;
        }
        System.out.println(Arrays.toString(ans));
        
    }

    public static void occurrencesOfElement1(int[] nums, int[] queries, int x) {
        int[] freq = new int[10001]; // Assuming values in nums are between 0 and 10000 (adjust if needed)
        for (int num : nums) {
          freq[num]++;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
          ans[i] = queries[i] <= freq[x] ? queries[i] : -1;
        }
        System.out.println(Arrays.toString(ans));
      }

}
 