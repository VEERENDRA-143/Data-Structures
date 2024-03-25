public class SingleNumber {

    public static void main(String[] args) {
        int[] arr={2,2,1};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
       
        int XOR=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            XOR=XOR^nums[i];
        }
        return XOR;
    }
    
}