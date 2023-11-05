public class InfinteArray {
    public static void main(String[] args) {
        int[] arr={3,5,7,9,10,15,17,20,32,35,38,40,45,49,50,52,55,59,60,69,70,72,74,75,77,79,80,84,87,89,90,95,100,105,108,110,115,120};
        int target =60;
        System.out.println("Hello");
        System.out.println(ans(arr, target));
        
        System.out.println("End");

    }
    static int ans(int[] arr,int target){
        // Find the Range
        // Start with box of size 2
        int start =0;
        int end=1;
        while(target>arr[end]){
            int newStart = end+1;
            // double the box size
            // end = previous end + sizeofbox*2;
            end = end+ ((end-start+1)*2);
            start = newStart;
        }
        return binarysearch(arr, target, start, end);
    }
    static int binarysearch(int[] arr,int target,int start,int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
