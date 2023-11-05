public class Binarysearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,7,9,10,20,36,48,56};
        int target = 36;
        binarysearch(arr,target);
    }
    static void binarysearch(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        while (low < high) {
            if(target>arr[mid]){
                low  = mid+1; 
            }
            else if(target<arr[mid]){
                high=mid-1;
            }
            else{
                System.out.println("Position is : "+mid);
                break;
            }
            mid=(low+high)/2;
        }
    }
}
