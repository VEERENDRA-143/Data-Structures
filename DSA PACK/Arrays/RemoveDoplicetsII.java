public class RemoveDoplicetsII {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicatesII(arr));
    }
    public static int removeDuplicatesII(int[] arr){
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length==0) {
            return 0;
        }
        int max = maxelement(arr);
        int[] count = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j=0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]==1) {
                arr[j]=i;
                j++;
            }
            if (count[i]>=2) {
                arr[j++]=i;
                arr[j++] = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("j = "+j);
        return j;
    }
    static int maxelement(int[] arr){
        int max=0;
        for (int i : arr) {
            if (i>max) {
                max=i;
            }
        }
        return max;
    }
}
