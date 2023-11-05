public class Guss_a_Number {
    public static void main(String[] args) {
        System.out.println(guessNumber(10, 6));
        System.out.println(guessNumber(1, 1));
        System.out.println(guessNumber(2, 1));
    }
    
    public static int guessNumber(int n,int target) {

        if(n<target){
            return -1;
        }
        int start = 0;
        int end  =n;
        int mid = (start+end)/2;
        while (start<=end) {
            if(mid<target){
                start = mid+1;
            }
            else if(mid>target){
                end = mid-1;
            }
            else{
                return mid;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
