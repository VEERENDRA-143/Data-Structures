import java.util.Arrays;

public class EftronicsJumpAndJump {
    public static void main(String[] args) {
        int P = 6;
        int X = 2;
        int L = 4;
        findMaxScore(P, X, L);
    }
    public static void findMaxScore(int P, int X,int L) {

        int ans = f(P, X, L);
        System.out.println(ans);

    }
    private static int f(int p, int x, int l) {

        if (x == 0) {
            return p;
        }

        int forward =   f( Math.abs(p + l) , x - 1, l);
        int backward =  f( Math.abs(p - l), x - 1, l);

        return Math.min( forward, backward);
        
    }
}
