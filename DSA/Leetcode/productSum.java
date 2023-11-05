public class productSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    static int subtractProductAndSum(int n) {

        int pro=1;
        int sum=0;
        int rem;
        while (n!=0) {
            rem = n%10;
            pro = pro*rem;
            sum = sum+rem;
            n=n/10;
        }
        int diff= pro-sum;
        return diff;
    }
}
