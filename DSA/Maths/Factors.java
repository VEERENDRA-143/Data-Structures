public class Factors {
    public static void main(String[] args) {

        fact1(100);
    }

    static void fact1(int n){
        for (int i = 1; i < n/2+1; i++) {
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }

}
