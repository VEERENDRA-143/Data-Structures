public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 2;
        arrangeCoins(n);
    }
    public static int arrangeCoins(int n) {
        if (n<=1) {
            return 1;
        }
        int i=1;
        int res =0 ;
        while (n>0 && i<n) {
            if (n%i==0) {
                res=i;
            }
            n = n-1;
            i++;
        }
        System.out.println(res);
        return res;
    }
}
