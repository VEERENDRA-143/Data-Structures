public class Valid_perfect_square {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(15));

    }
    public static boolean isPerfectSquare(int num) {

        int start =0;
        int end = num;
        int mid = (start+(end-start))/2;
        while(start<=end){
            if((long)mid*mid > num){
                end = mid-1;
            }
            else if((long)mid*mid < num){
                start = mid+1;
            }
            else{
                return true;
            }
            mid = (start+end)/2;
        }
        return false;
    }
}
