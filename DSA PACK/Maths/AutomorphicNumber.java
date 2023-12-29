// Given a number N, the task is to check whether the number is an Automorphic number or
//  not. A number is called an Automorphic number if and only if its square ends in the same digits as the number itself
public class AutomorphicNumber {

    public static void main(String[] args) {
        String ans = Automorphic(25);
        System.out.println(ans);
    }
    static String Automorphic(int N){

        int squre = N*N;
        int squareend=0;
        int temp=0;

        while (N!=0) {
            temp=(temp*10)+(N%10);
            squareend =(squareend*10)+(squre%10);
            squre = squre/10;
            N=N/10;
        }

        return (temp==squareend)?"Automorphuic Number!!":"Not A Automorphic Number!!!!!";
    }
}
    // Input  : N = 76 
    // Output : Automorphic
    // Explanation: As 76*76 = 5776

    // Input  : N = 25
    // Output : Automorphic
    // As 25*25 = 625