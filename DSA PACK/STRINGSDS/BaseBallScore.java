import java.util.*;
public class BaseBallScore {
    public static void main(String[] args) {
        String[] operations = {"1","C"};
        System.out.println(calPoints(operations));
    }
    public static int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String string : operations) {
            if (string.equals("C")) {
                list.remove(list.size()-1);
            }
            else if (string.equals("D")) {
                int ele = list.get(list.size()-1);
                    
                list.add(2*ele);
            }
            else if (string.equals("+")) {
                int a = list.get(list.size()-1);
                int b = list.get(list.size()-2);
                list.add(a+b);
            }
            else{
                list.add(Integer.parseInt(string));
            }
        }

        int ans = 0;
        for (Integer integer : list) {
            ans+=integer;
        }
        return ans;
    }
}
