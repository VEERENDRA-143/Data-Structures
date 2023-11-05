

public class QuestOne {
    public static void main(String[] args) {
        N_TO_ONE(5);
    }

    static void N_TO_ONE(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        N_TO_ONE(n - 1);
    }

    static void ONE_TO_N(int n) {
        if (n == 0) {
            return;
        }
        ONE_TO_N(n - 1);
        System.out.println(n);
    }

    static void Both(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        Both(n - 1);
        System.out.println(n);
    }
}
