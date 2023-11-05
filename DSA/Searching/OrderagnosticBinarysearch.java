public class OrderagnosticBinarysearch {
    public static void main(String[] args) {
        int[] arr = new int[]{16,13,10,9,8,7,5,4,3};
        int target = 13;
        binarysearch(arr,target);
    }
    static void binarysearch(int[] arr,int target){
        
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;

        // Checking Ascending Sort or Descending Sort of Array.
        boolean isAsc = arr[low]<arr[high];

        while (low < high) {


            if (target==arr[mid]){
                System.out.println("Position is : "+mid);
                break;
            }

            if(isAsc){
                if(target>arr[mid]){
                low  = mid+1; 
                }
                else{
                    high=mid-1;
                }
            }
            else{
                if(target<arr[mid]){
                    low  = mid+1; 
                }
                else{
                    high=mid-1;
                }
            }
            
            mid=(low+high)/2;
        }
    }
}
