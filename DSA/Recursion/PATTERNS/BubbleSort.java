public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={6,3,6,1,8,10};
        int l = arr.length-1;
        bubble(arr, l, 0);
        quiz();
    }
    static void bubble(int[] arr,int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            if(arr[col]>arr[col+1]){
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1]=temp;
            }

            bubble(arr,row, col + 1);
        } else {
            bubble(arr,row - 1, 0);
        }
    }

    static void quiz(){
        String letters = "";
        while (letters.length()!=2) {
            letters+="a";  
        }
        System.out.println(letters);
    }
}
