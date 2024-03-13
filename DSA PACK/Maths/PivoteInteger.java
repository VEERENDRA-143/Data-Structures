// Given a positive integer n, find the pivot integer x such that:

// The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
// Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

public class PivoteInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }
    public static int pivotInteger(int n) {
        if (n == 1) {
            return n;
        }
        int res;
        int start = 0;
        int end = n;
        res = (n*(n+1))/2;
        int mid = (start+end)/2;
        while (start < end) {
            
            if (mid*mid == res) {
                return mid;
            }   
            if (mid*mid > res) {
                end = mid-1;
            }
            if (mid*mid < res) {
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
