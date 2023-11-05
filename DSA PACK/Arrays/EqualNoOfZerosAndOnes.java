public class EqualNoOfZerosAndOnes {
    public static void main(String[] args) {
        int[] arr={1, 0, 0, 1, 0, 1, 1};
        ZerosAndOnes(arr);
    }

    static void ZerosAndOnes(int[] arr){
        int c0=0,c1=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length; j++) {
                if (arr[i] == 0) {
                    c0++;
                }
                if (arr[i] ==1) {
                    c1++;
                }
                if (arr[j] == 0) {
                    c0++;
                }
                if (arr[j] ==1) {
                    c1++;
                }

                if (c0==c1) {
                    System.out.println("start : "+i+" "+"end : "+j);
                }

            }
        }
    }
}
