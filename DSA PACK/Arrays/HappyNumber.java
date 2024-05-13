public class HappyNumber {
    public static void main(String[] args) {
        isHappy(2);
    }
    public static boolean isHappy(int n) {
        int sum=0;
        
        while (n!=0) {
            int rem = n%10;
            sum = sum+rem*rem;
            System.out.print(rem +" ");
            n = n/10;
        }
        if (sum==1) {
            System.out.println("true");
            return true;
        }
        System.out.println();
        isHappy(sum);
        return false;
    }
}
