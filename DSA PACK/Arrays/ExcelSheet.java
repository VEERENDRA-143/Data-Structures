public class ExcelSheet {
    public static void main(String[] args) {
        int columnNumber=701;
        convertToTitle(columnNumber);
    }
    public static void convertToTitle(int columnNumber){
        String ans = "";
        while ( columnNumber > 0 ){
            int r = columnNumber % 26;
            columnNumber = (columnNumber - 1) / 26;
            r--;
            if(r < 0)
                r = 25;
            char c = (char)('A' + r  );
            ans = c+ans;
        }
        System.out.println(ans);
    }
}
