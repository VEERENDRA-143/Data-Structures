public class DivisibleAndNonDivisible {
    public static void main(String[] args) {
        int n = 5;
        int m = 1;
        differenceOfSums(n, m);
    }
    public static void differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i%m != 0) {
                num1+=i;
            }
            else{
                num2+=i;    
            }
        }
        System.out.println(num1 + " "+num2);
    }
}
