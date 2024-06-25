public class AddDigits {
    public static void main(String[] args) {
        int num = 0;
        addDigits(num);
    }
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                int rem = num%10;
                sum += rem;
                num/=10;
            }
            num = sum;
        }
        System.out.println(num);
        return num;
    }
}
