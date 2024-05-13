public class TakingMaxEnergy {
    public static void main(String[] args) {
        int[] energy = {5,2,-10,-5,1};
        int k=3;
        System.out.println(maximumEnergy(energy, k));
    }
    public static int maximumEnergy(int[] energy, int k) {
        int ans = Integer.MIN_VALUE, temp, n = energy.length;
        int sum = 0, i = 0, j = i;
        for (i = 0; i < n;)
        {
            sum += energy[j];
            if (j + k < n)
                j = j + k;
            else
            {
                ans = Math.max(ans, sum);
                sum = 0;
                i++;
                j = i;
            }
        }
        return ans;
    }
}
