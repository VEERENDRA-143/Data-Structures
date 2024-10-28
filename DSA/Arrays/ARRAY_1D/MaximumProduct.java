public class MaximumProduct {
    public static void main(String[] args) {
        int[] arr = {8, 9, 2, -1, -2, -9};
        int l = 4;
        int r = 6;
        long ans = maximumProduct(arr.length, arr, l, r);
        System.out.println(ans);
    }
    public static long maximumProduct(int n, int[] arr, int l, int r) {
        long maxEleIn = findmax(arr,l,r);
        long maxEleOut = findOutmax(arr,l,r);
        return maxEleIn*maxEleOut;
     }
    private static long findOutmax(int[] a, int l, int r) {
        long max = a[0];
        for(int i= 0; i<l-1;i++){
            max = Math.max(max,(long)a[i]);
        }
        
        for(int i = r; i < a.length; i++){
            max = Math.max(max,(long)a[i]);
        }
        return max;
        
    }
    private static long findmax(int[] a, int l, int r) {
        if(l==r) return (long)(a[l-1]);
        long max = a[l-1];
        
        for(int i =l-1; i <= r-1; i++ ){
            if(max < (long)a[i]){
                max = (long)a[i];
            }
        }
        return max;
    }
}
