public class DifferenceofSumProduct {
    public static void main(String[] args) {
        System.out.println(Difference(234));
    }
    static int Difference(int n){
        int pro=1;
        int add=0;
        int rem;
        while(n!=0){
            rem = n%10;
            add+=rem;
            pro*=rem;
            n/=10;
        }
        return (pro-add);
    }
}
