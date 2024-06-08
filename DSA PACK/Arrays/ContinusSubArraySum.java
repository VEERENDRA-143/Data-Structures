import java.util.HashMap;

public class ContinusSubArraySum {
    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        checkSubarraySum( nums , k );
    }

    // TC => O(n^2)
    public static void checkSubarraySum(int[] nums, int k){

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            sum+=nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");

    }

    // TC => O(n)
    public static boolean checkSubarraySum2(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }
}
