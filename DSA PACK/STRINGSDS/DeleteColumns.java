public class DeleteColumns {

    public static void main(String[] args) {
        String[] strs = { "abc", "bce", "cae" };
        System.out.println(minDeletionSize(strs));
    }

    public static int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int n = strs.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);

            int flag = 0;
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < ch) {
                    flag = 1;
                }
                ch = strs[j].charAt(i);
            }
            if (flag == 1) {
                cnt++;
            }

        }
        return cnt;
    }
}
