public class Facnacii {
    public static void main(String[] args) {
        System.out.println(Febi(50));
    }
    static void fabnaccii(int n){
        int n1=0,n2=1;
        int temp;
        System.out.println(n1);
        System.out.println(n2);
        while (n>=0) {
            temp = n1+n2;
            System.out.println(temp);
            n1=n2;
            n2= temp;
            n--;
        }
    }

    static int Febi(int n){
        // base condition
        if (n<2) {
            return n;
        }
        return Febi(n-1)+Febi(n-2);
    }
}
