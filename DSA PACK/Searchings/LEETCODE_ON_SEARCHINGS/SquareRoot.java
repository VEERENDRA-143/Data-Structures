public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(-2));
    }

    public static int mySqrt(int x) {
        
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0;
        int end = x;
        int mid = (start + end) / 2;
        while (start <= end) {
            if ((long) mid * mid > x) {
                end = mid - 1;
            } else if ((long) mid * mid < x) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }

        return mid;
    }
}
