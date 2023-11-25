public class FirstNonReapetingElement {

    public static void main(String[] args) {
        NONReeaptingElement("abcabcdf", "");
    }

    static void NONReeaptingElement(String string, String updatedString) {
        char fnc;
        int index=-1;
        for (char i : string.toCharArray()) {
            if (string.indexOf(i) == string.lastIndexOf(i)) {
                fnc = i;
                System.out.println(fnc);
                break;
            }
            else {
                index += 1;
            }
        }
    }
}