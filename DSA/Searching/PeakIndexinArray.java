public class PeakIndexinArray {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,6,7,3,2,1};
        
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        System.out.println("max element index is : "+start);
        
    }
    
}
