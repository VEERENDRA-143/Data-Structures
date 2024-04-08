import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSumInTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(-1)));
        triangle.add(new ArrayList<>(Arrays.asList(2,3)));
        triangle.add(new ArrayList<>(Arrays.asList(1,-1,-3)));
        // triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        minimumTotal(triangle);
    }
    public static void minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i =0 ;i< n;i++) dp[i] = triangle.get(n-1).get(i);
        
        for(int i =n-2 ;i >= 0;i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
       System.out.println(dp[0]);
        
    }

}
