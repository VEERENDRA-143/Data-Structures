import java.util.Stack;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.01",
                version2 = "1.1";
        System.out.println(compareVersion2(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {

        String[] strArrVersion1 = version1.split("[.]");
        String[] strArrVersion2 = version2.split("[.]");

        int Version1 = extractInteger(strArrVersion1);
        int Version2 = extractInteger(strArrVersion2);

        System.out.println(Version1 + " " + Version2);

        if (Version1 < Version2) {
            System.out.println("-1");
            return -1;
        }
        if (Version1 > Version2) {
            System.out.println("1");
            return 1;
        }

        return 0;

    }

    private static int extractInteger(String[] strArrVersion1) {
        String sv1 = "";
        int Sv1 = 0;
        for (int i = 0; i < strArrVersion1.length; i++) {
            // System.out.print(strArrVersion1[i]+" ");
            strArrVersion1[i] = removeLeadingZeros(strArrVersion1[i]);

            if (strArrVersion1[i] != "") {
                sv1 += strArrVersion1[i];
                Sv1 = Sv1 * 10 + (sv1.charAt(i) - '0');
            } else {
                sv1 += "0";
            }

            // System.out.println(" char to int " + (sv1.charAt(i)-'0') + " Sv1 = "+Sv1);
        }
        return Sv1;
    }

    private static String removeLeadingZeros(String str) {
        int start = 0;
        if (str.length() == 1 && str.charAt(start) == '0') {
            return "";
        }
        while (str.charAt(start) == '0' && start < str.length()) {
            start++;
        }
        // System.out.println(str.substring(start));
        return str.substring(start);
    }

    public static int compareVersion2(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

}
