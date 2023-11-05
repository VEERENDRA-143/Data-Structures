public class Pattern1 {

    public static void main(String[] args) {
        pattern_7(5);
    }

    static void pattern_1(int m) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println("");
        }
    }

    static void pattern_2(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print("*" + " ");
            }
            System.out.println("");
        }
    }

    static void pattern_3(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = m; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    static void pattern_4(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    static void pattern_5(int m) {
        for (int row = 0; row < 2 * m; row++) {
            int totalrowsincols = row > m ? 2 * m - row : row;
            for (int col = 0; col < totalrowsincols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Dimond
    static void pattern_6(int m) {
        for (int row = 0; row < 2 * m; row++) {
            int totalrowsincols = row > m ? 2 * m - row : row;
            int NoOfSpaces = m - totalrowsincols;
            for (int i = 0; i < NoOfSpaces; i++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalrowsincols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern_7(int m){
        for (int row = 1; row < m; row++) {
            int NoOfSpaces = m - row;
            for (int space = 1; space < NoOfSpaces; space++) { //printing spaces
                System.out.print("  ");
            }
            for (int col = row; col >=1; col--) {
                System.out.print(col+" ");
            }
            for (int col = 0; col <= row ; col++) {
                System.out.print(col+ " ");
            }
            System.out.println();
        }
    }
}