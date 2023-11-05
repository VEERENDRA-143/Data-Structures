public class Pattern1 {
    public static void main(String[] args) {

        print2(5, 5);
    }

    static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void print2(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            print2(row, col + 1);
            System.out.print("* ");
        } else {
            print2(row - 1, 0);
            System.out.println();
        }
    }
}