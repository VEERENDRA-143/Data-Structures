public class HarasedNumber {
    public static void main(String[] args) {
        int x = 23;
        sumOfTheDigitsOfHarshadNumber(x);
    }
    public static void sumOfTheDigitsOfHarshadNumber(int x) {
        int n = x;
        int sum = 0;
        while (x != 0) {
            int rem = x%10;
            sum+=rem;
            x = x/10;
        }
        System.out.println(n%sum);
    }
}
