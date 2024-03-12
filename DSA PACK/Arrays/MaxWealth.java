public class MaxWealth {
    public static void main(String[] args) {
        int[][] nums = {
            {1,5},
            {7,3},
            {3,5}
        };
        System.out.println(maximumWealth(nums));
    }
    public static int maximumWealth(int[][] accounts) {
        
        int wealth=0;
        int max=0;
        for (int i = 0; i < accounts.length; i++) {
            
            for (int j = 0; j < accounts[i].length; j++) {
                wealth = wealth+accounts[i][j];
            }
            if (max<=wealth) {
                max=wealth;
            }
            wealth=0;
        }

        return max;

    }
}
