public class FindElementinPeak {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 3, 2, 1 };
        int target = 3;
        int pindex = peakindex(arr);
        binarysearch(arr,target,pindex);

    }

    static int peakindex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;            
            }

        }
        return start;
    }

    static void binarysearch(int[] arr,int target,int pindex){
        int start =0;
        int end=pindex;
        while(start<end){
            int mid = (start +(end-start))/2;
            if(arr[mid]>target){
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                System.out.println("Index is at : "+mid);
                break;
            }
        }
    }
}
