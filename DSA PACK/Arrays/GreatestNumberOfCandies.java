import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] nums ={12,1,12};
        int extracandies = 10;
        List<Boolean> list = kidswithcandies(nums, extracandies);
        for (Boolean boolean1 : list) {
            System.out.println(boolean1);
        }
    }
    private static List<Boolean>  kidswithcandies(int[] candies, int extracandies){
        List<Boolean> list = new ArrayList<>();
        int max=Max(candies);
        for (int i = 0; i < candies.length; i++) {
           Boolean x =  ((candies[i]+extracandies)>=max)? true : false ;
           list.add(x);
            
        }
        return list;
    }
    private static int Max(int[] candies) {
        int max=0;
        for (int i : candies) {
            if (i>max) {
                max=i;
            }
        }
        return max;
    }
}
