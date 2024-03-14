public class MaximumBridges {
    public static void main(String[] args) {
        int[] a={1,2,3};
        int[] b = {3,2};
        maximumBridges(3, 2, a, b);
    }
    public static void maximumBridges(int n, int m, int[] a, int[] b) 
    {   
        int i=0,j=0;
        int count=0;
        while (i!=n || j!=m) {
            if (a[i]==b[j]) {
                count++;
            };
        }
        System.out.println(count);
    }
}
