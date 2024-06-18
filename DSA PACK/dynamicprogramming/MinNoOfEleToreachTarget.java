public class MinNoOfEleToreachTarget {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        int target = 7;
        System.out.println(minimumElements(num, target));
    }
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        return f(num.length-1,x,num);
    }
    private static int f(int ind, int target, int[] num) {
        if (ind == 0) {
            if (num[ind] % target == 0) {
                return target|num[ind];
            }
            return (int)1e9;
        }

        int nottake = 0 + f(ind-1, target, num);
        int take = Integer.MAX_VALUE;
        if (num[ind] <= target) {
            take = 1  + f(ind, target-num[ind], num);
        }

        return Math.min(nottake, take);

    }
}
