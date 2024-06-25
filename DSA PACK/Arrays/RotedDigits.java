
public class RotedDigits {
    
    public static void main(String[] args) {
        int n =22;
        System.out.println(rotatedDigits(n));
    }
    public static int rotatedDigits(int n) {
        
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int x = getCount(i);
            if(x > 0) c++;
        }
        return c;
    }
    private static int getCount(int num) {

        int c = 0;
        while (num > 0) {
            int rem = num%10;
            if (rem == 3 || rem == 4 || rem == 7) return 0;
            if (rem == 2 || rem == 5 || rem == 6 || rem == 9) c++;
            num /= 10;
        }
        return c;
        
    }
}
