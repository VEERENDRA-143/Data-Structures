public class SmallString {
    public static void main(String[] args) {
        String s = "45320";
        System.out.println(getSmallestString(s));
    }
    public static String getSmallestString(String s) {
        
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length-1; i++) {

            
            if ((arr[i]-'0')%2  == (arr[i+1]-'0')%2 && (arr[i]-'0') > (arr[i+1]-'0')) {
                char temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                return new String(arr);
            }
           
        }

        
        return new String(arr);
    }
}
