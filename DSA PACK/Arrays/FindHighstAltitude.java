public class FindHighstAltitude {
    public static void main(String[] args) {
        int[] gain={44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        // int[] altitudes =  new int[gain.length+1];
        if (gain.length==1) {
            if (gain[0]<=0) {
                return 0;
            }else {
                return gain[0];
            }
        }
        int sum=0;
        int max=0;
        for (int i =0; i < gain.length; i++) {
            sum = sum+gain[i];
            // altitudes[i] = sum;
            max = Math.max(max, sum);
        }

        return max;
    }
}
