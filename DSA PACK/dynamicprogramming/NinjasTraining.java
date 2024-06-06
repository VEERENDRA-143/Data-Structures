public class NinjasTraining {
    public static void main(String[] args) {
        int n = 3;
        int[][] points = {
            {10 ,40, 70 },
            {20 ,50, 80 },
            {30 ,60, 90 },
        };
        // System.out.println(ninjaTraining(n, points));
        System.out.println(tabulation(n,points));
    }
    public static int ninjaTraining(int n, int points[][]) {
        return  f(n-1, 3, points);
        // Write your code here..
    }

    public static int f(int day,int last,int[][] points){
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points1 = points[day][i] + f(day-1, i, points);
                maxi = Math.max(maxi, points1);
            }
            
        }
        return maxi;
    }

    // Tabulation
    public static int tabulation(int n,int[][] points){

        int[][] dp = new int[n][points[0].length+1];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 3; last++) {
                dp[day][last] = Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][last] + dp[day-1][last];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][2];
    }



    // Memoization 
    public static int ninjaTraining2(int n, int points[][]) {
        int[][] dp = new int[points.length][points[0].length];
        return  f(n-1, 3, points,dp);
        // Write your code here..
    }

    private static int f(int day, int last, int[][] points, int[][] dp) {
        
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }
        if (dp[day][last] != 0) {
            return dp[day][last];
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points1 = points[day][i] + f(day-1, i, points,dp);
                maxi = Math.max(maxi, points1);
            }
            
        }
        return dp[day][last] = maxi;
    
    }

    
}
