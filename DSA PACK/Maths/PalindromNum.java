public class PalindromNum {
    public static void main(String[] args) {
        System.out.println(checkpanidrome(-101));
    }
    private static boolean checkpanidrome(int n){
        int temp=n;
        long ans=0;
        while (temp!=0) {
            ans = (ans*10)+(temp%10);
            temp=temp/10;
        }
        return ((int)ans==n && n>0) ? true : false;
    }
}
