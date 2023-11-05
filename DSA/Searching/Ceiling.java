public class Ceiling {
    public static void main(String[] args) {
        int[] arr= new int[]{2,5,7,9,10,16,19,20};
        int target = 18;
        System.out.println(ceiling_num(arr,target));
    }
    static int ceiling_num(int[] arr,int target){
        int low=0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        while(low <= high){
            if(target>arr[mid]){
                low = mid+1;
                // System.out.println("Celied Number is : "+arr[low]);
            }
            else if(target==arr[mid]){
                return arr[mid];
            }
            else{
                high=mid-1;

            }
            mid=(low+high)/2;
        }
        return arr[low];
    }
}

