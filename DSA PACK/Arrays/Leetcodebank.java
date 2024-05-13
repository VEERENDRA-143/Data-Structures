public class Leetcodebank {
    public static void main(String[] args) {
        int n =4;
        totalMoney(n);
    }
    public static void totalMoney(int n) {
        
        int dayShiftStart=1;
        int sum=0;
        int k =0;
        while (k<n) {
            int start = dayShiftStart;
            int end = 7+start;
            for (int i = start; i < end; i++) {
                if (i<=n && k<n) {
                    sum+=i;
                    k++;
                }
            }
            dayShiftStart++;
        }

        System.out.println(sum);

    }
}
