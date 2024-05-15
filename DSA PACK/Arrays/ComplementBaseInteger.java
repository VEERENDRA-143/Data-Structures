public class ComplementBaseInteger {
    public static void main(String[] args) {
        int n = 5;
        bitwiseComplement(n);
    }
    public static void bitwiseComplement(int num) {

        int s=0;
        int sum=0;
        while((num>>s)>0){
            System.out.println(num>>s);
            if(((num>>s)&1)==0){
                sum+=(1<<s);
            }
            s+=1;
        }

        // String bitsString = "";
        // while (n != 0) {
        //     int rem = n % 2;
        //     rem = rem ==0 ? 1 : 0;
        //     bitsString+=rem;
        //     n = n/2;
        // }
        // int sum = 0;
        // for (int i = 0; i < bitsString.length(); i++) {
        //     sum += ((bitsString.charAt(i)-'0')*(int)(Math.pow(2, i)));
        // }
        // System.out.println(bitsString);
        System.out.println(sum);
    }
}
