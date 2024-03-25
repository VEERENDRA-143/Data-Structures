
public class ValidMountanarray {

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1,0};
        // System.out.println(validmoutainArray(arr));
        System.out.println(validMountainArray(arr));
    }


    public static boolean validMountainArray(int[] arr) {
        int peak =0;
        int first=0;
        int second =1;
        if (arr.length==2) {
            return false;
        }
        if (arr[0]>arr[1]) {
            return false;
        }
        while (peak==0 && second<arr.length) {
            if (arr[first]<arr[second]) {
                first++;
                second++;
            }
            else if (arr[first]==arr[second]) {
                return false;
            }
            else{
                if (arr[first]>arr[second]) {
                    peak=arr[first];
                }
            }
        }
        if (peak==0) {
            return false;
        }
        while (second < arr.length) {
            if (arr[first]>arr[second]) {
                first++;
                second++;
            }
            else{
                return false;
            }
        }
        return true;
    }



    public static boolean validmoutainArray(int[] arr){
        int peak=0;
        if (arr.length<=2) {
            return false;
        }
        if (arr.length==3 && arr[1]<arr[0] && arr[1]<arr[2]) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1] && arr[i]>arr[i+1] ) {
                peak=arr[i];
                i++;
            }
            if (arr[i]==arr[i-1]) {
                System.out.println("not strictly incresing");
                return false;
            }
            if (peak != 0) {
                int flag=0;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j]<arr[j-1]) {
                        flag=0;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

}