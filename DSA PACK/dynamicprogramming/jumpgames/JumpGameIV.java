public class JumpGameIV {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }
    public static int minJumps(int[] arr) {
        return f(0, arr);
    }
    public static int f(int ind,int[] arr){

        if (ind > arr.length - 1 || ind < 0) {
            return 99999;
        }

        if (ind == arr.length-1) {
            return 0;
        }

        int left = 1 +f(ind+1, arr);
        int right = 1 +f(ind-1, arr);
        int jJump = 99999;
        for (int j = ind+1; j < arr.length; j++) {
            if (arr[ind] == arr[j]) {
                jJump = Math.min(jJump,1+ f(j, arr));
            }
        }
        return Math.min(left, Math.min(right, jJump));
    }
}
