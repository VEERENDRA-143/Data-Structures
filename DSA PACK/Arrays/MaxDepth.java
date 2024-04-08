public class MaxDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        maxDepth(s);
    }
    public static void maxDepth(String s) {
        int maxNum = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                if (maxNum<count) {
                    maxNum = count;
                }
            }
            else if (ch == ')') {
                count--;
            }   
        }
        System.out.println(maxNum);
    }
}
