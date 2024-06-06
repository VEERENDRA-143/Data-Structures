import java.util.ArrayList;

public class LongestCommonPrifx {
    public static void main(String[] args) {
        String[] strs = { "dog", "doracecar", "docar" };
        longestCommonPrefix(strs);
    }

    // Broute Force Approch  O(n*n)
    public static void longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String str = "";
        for (String string : strs) {
            if (string.length() < min) {
                min = string.length();
                str = string;
            }
        }
        int flag = 0;
        String ans = "";
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    flag = 1;
                } else {
                    flag = 0;
                    System.out.println(ans);
                    return;
                }
            }
            if (flag == 1) {
                ans += str.charAt(i);
            }
        }
        System.out.println(ans);
    }


    // Approch -2 Binary Search O(n*log(n))
    public static String longestCommonPrefixbinarySerch(String[] strs) {
        if (strs.length == 0)
            return "";

        // Find the minimum length string in the array
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1, high = minLen;

        while (low <= high) {
            int middle = (low + high) / 2;
            String prefix = strs[0].substring(0, middle);
            boolean isCommon = true;

            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

}
