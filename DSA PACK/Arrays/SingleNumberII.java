
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = { 30000, 500, 100, 30000, 100, 30000, 100 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }

        return ones;
    }
}
