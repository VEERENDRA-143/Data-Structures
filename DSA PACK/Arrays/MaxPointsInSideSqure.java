import java.util.Arrays;

public class MaxPointsInSideSqure {
    public static void main(String[] args) {
        int[][] points = {
                { 2, 2 },
                { -1, -2 },
                { -4, 4 },
                { -3, 1 },
                { 3, -3 },
        };
        String str = "abdca";
        System.out.println(maxPointsInsideSquare(points, str));
    }

    public static int maxPointsInsideSquare(int[][] points, String str) {
        int[] dp = new int[26];
        int min = Integer.MAX_VALUE, result = 0;
        int size, temp;
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i < points.length; i++) {

            size = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));

            if (dp[str.charAt(i) - 'a'] > size) {

                temp = size;
                size = dp[str.charAt(i) - 'a'];
                dp[str.charAt(i) - 'a'] = temp;

            }
            min = Math.min(min, size);
        }
        for (int element : dp) {
            if (element < min)
                result++;
        }
        return result;
    }
}
