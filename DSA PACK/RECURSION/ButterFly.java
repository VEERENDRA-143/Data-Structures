public class ButterFly {
    public static void main(String[] args) {
        int r = 2;
        int g = 5;
        int b = 4;
        findbutterFlys(r, g, b);
    }
    public static void findbutterFlys(int r, int g, int b){
        int max = Math.max(r,Math.max(g,b));

        int s = r + g + b - max;
        if (max > s) {
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
    }
}
