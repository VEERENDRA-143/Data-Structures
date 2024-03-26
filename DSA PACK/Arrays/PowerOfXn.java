// LeetCode : 50

public class PowerOfXn {
    public static void main(String[] args) {
        myPow(2.00000, -2147483648);
    }
    public static void myPow(double x, int n) {
        System.out.println(Math.pow(x, (long)n));
    }
}
