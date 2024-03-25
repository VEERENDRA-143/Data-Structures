import java.util.ArrayList;
import java.util.Arrays;

public class PluseOne {
    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        plusOne(digits);
    }
    public static int[] plusOne(int[] digits) {
        int num = 0;
        int size = digits.length-1;
        for (int i = 0; i < digits.length; i++) {
            num =num+ (digits[i] * (int)Math.pow(10, size));
            size--;
        }
        num = num+1;
        ArrayList<Integer> list = new ArrayList<>();
        while (num!=0) {
            list.add(num%10);
            num = num/10;
        }
        int s = list.size();
        int[] ans = new int[s];
        for (Integer integer : list) {
            ans[s-1] = integer;
            s--;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
