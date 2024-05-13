import java.util.Arrays;

public class MaximumCandiesToKChildren {

    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;
        System.out.println(maximumCandies(candies, k));
    }

    public static int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        for (int currentCandies : candies) {
            totalCandies += currentCandies;
        }
        int min = 1;
        int max = (int)(totalCandies/k);

        // binary search to find out which is the maximum number of candies
        while (min <= max) {
            int middle = (min-max) / 2 + max;
            long count = 0;
            for (int currentCandies : candies) {
                count += currentCandies / middle; // summing sub-piles
            }
            if (count >= k) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return max;
    }
    
}