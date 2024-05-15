import java.util.Scanner;

public class NoOfPairsOfStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] digits = new String[n];

        for (int i = 0; i < n; i++) {
            digits[i] = scn.nextLine();
        }
        
        String target = scn.nextLine();
        findPairs(digits, target);
    }
    public static void findPairs(String[] digits,String target){
        int count=0;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i!=j) {
                    if ((digits[i]+digits[j]).equals(target)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
