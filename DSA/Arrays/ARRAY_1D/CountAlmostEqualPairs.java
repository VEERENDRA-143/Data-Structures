public class CountAlmostEqualPairs {
    public static void main(String[] args) {
        int[] nums = {3,12,30,17,21};
        countPairs(nums);
    }
    public static void countPairs(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                boolean check = checkEqueal(nums[i], nums[j]);
                if (check) {
                    c++;
                }
            }
        }
        System.out.println(c);
    }
    private static boolean checkEqueal(int n, int m) {
        
        String str1 = String.valueOf(n);
        String str2 = String.valueOf(m);

        while (str1.length() < str2.length()) {
            str1 = "0"+str1;
        }
        while (str2.length() < str1.length()) {
            str2 = "0"+str2;
        }
        int noOfIndex = 0;
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                noOfIndex++;
                if (noOfIndex == 1) {
                    firstIndex = i;
                }
                else if (noOfIndex == 2) {
                    secondIndex = i;
                }
                else{
                    return false;
                }
            }
        }

        if (noOfIndex == 2) {
            char[] strArr2 = str2.toCharArray();
            char ch = strArr2[firstIndex];
            strArr2[firstIndex] = strArr2[secondIndex];
            strArr2[secondIndex]  = ch;
            str2 = new String(strArr2);
        }
        
        return str1.equals(str2);
    }
}
