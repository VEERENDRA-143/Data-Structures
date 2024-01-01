public class FindDuplicateElement {
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
                break;
            } else {
                count--;
            }
        }

        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }
}
