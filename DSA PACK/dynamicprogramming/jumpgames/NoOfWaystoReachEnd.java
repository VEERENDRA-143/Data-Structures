public class NoOfWaystoReachEnd {
    public static void main(String[] args) {
        int statr = 2;
        int end = 5;
        System.out.println(f(statr, end));
    }
    public static int f(int start,int end){

        if (start == end) {
            return 1;
        }

        if (start > end) {
            return 0;
        }
        

        return f(start+1, end) + f(start+2, end )+ f(start+3, end);
    }
}
