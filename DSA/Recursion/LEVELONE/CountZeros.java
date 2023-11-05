public class CountZeros {
    public static void main(String[] args) {
        count_zeros(100000000,0);
    }

    static void zeros(int n) {
        int rem;
        int count = 0;
        while (n != 0) {
            rem = n % 10;
            if (rem == 0) {
                count++;
            }
            n = n / 10;
        }
        System.out.println(count);
    }

    // With recursion 
    static void count_zeros(int n,int count){
        int rem;
        if (n==0){
            System.out.println(count);
            return;
        }
        rem = n%10;
        if (rem==0) {
            count++;
        }
        count_zeros(n/10,count);
       
    }
}