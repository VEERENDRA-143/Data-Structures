public class FindTheChildwhohasKsec {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(numberOfChild(n, k));
    }
    public static int numberOfChild(int n, int k) {
        n--;
        int rounds = k/n;
        int rem = k%n;
        if(rounds % 2 ==0){
            return rem;
        }
        return n-rem;
    }
}
