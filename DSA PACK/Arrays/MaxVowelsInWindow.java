public class MaxVowelsInWindow {
    public static void main(String[] args) {
        String s = "leetcode";
        int k= 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        String vowels = "aeiouAEIOU";
        int i=0,j=0;
        int max=0;
        while (i<s.length() && (j+k)<=s.length()) {
            i=j;
            int sum=0;
            for (int l = i; l < j+k; l++) {
                if (vowels.indexOf(s.charAt(l))>=0) {
                    sum++;
                }
            }
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}
