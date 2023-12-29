
// Given N, check whether it is a Narcissistic number or not.
// Note:Narcissistic Number is a number that is the sum of its own digits each raised to the power of the number of digits.

public class NarsisticNumber {
    public static void main(String[] args) {
        FindNarsisticNumber(1634);
    }

    static void FindNarsisticNumber(int N){
        int temp = N;
        int ans=0;
        int len = FindLength(N);
        while (N!=0) {
            int rem = N%10;
            ans=(int) (ans + Math.pow(rem,len));
            N=N/10;
        }
        System.out.println((temp==ans)?"Narsistic Number":"Not Narsistic Number!");
    }

    private static int FindLength(int n) {
        int len=0;
        while (n!=0) {
            len++;
            n=n/10;
        }
        return len;
    }
}
