public class MaximumAverageSubArray {
    public static void main(String[] args) {
        int[] nums={8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        System.out.println(nums.length);
        int k=94;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length ==1) {
            return (double)nums[0];
        }
        if (k==0) {
            return -1;
        }
        double ls=0;
        if (nums.length<k) {
            for (int l = 0; l < nums.length; l++) {
                ls+=nums[l];
            }

            return (double)ls/nums.length;
        }
        int i=0;
        int j=0;
        double max=0;
        while (i<nums.length && (j+k)<=nums.length ) {
            i=j;
            int sum=0;
            for (int l = i; l < j+k; l++) {
                sum+=nums[l];
            }
            max = Math.max(max, sum);
            j++;
        }


        return max/k;
    }
}


// ============== SECOND APPROCH ==============

// double m=Integer.MIN_VALUE;
// double d=0;
// double s=0;
// for(int i=0;i<nums.length;i++)
// {
//     s=s+nums[i];
//     if(i>=k-1)
//     {
//         d=s/k;
//         m=Math.max(m,d);
//         s=s-nums[i-(k-1)];
//     }

// }
// return m;