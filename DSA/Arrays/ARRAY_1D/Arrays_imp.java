// import java.util.ArrayList;
// import java.util.Scanner;

public class Arrays_imp {
    public static void main(String[] args) {
        // int[] arr=new int[]{1,7,3,8,9,0};
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        // String[] arr1 = new String[]{"rock","jock","jhon","joe"};

        // for (String string : arr1) {
        //     System.out.println(string);
        // }
        // for (int index = 0; index < args.length; index++) {
        //     System.out.println(args[index]);
        // }


        // 2-D array

        // int[][] arr = {
        //     {1,7,9},
        //     {8,23},
        //     {8,60,10}
        // };
        // for (int row = 0; row < arr.length; row++) {
        //     for (int col = 0; col < arr[row].length; col++) {
        //         System.out.print(arr[row][col] + " ");
        //     }
        //     System.out.println("");
        // }

        // Dynamic Arrays using Array lists

        // ArrayList<Integer> list = new ArrayList<>(10);
        // list.add(100);
        // list.add(29);
        // list.add(150);
        // list.add(294);
        // list.add(1006);
        // list.add(292);
        // list.add(14);
        // list.add(29);
        // list.add(100);
        // list.add(29);
        // list.add(29);
        // list.add(150);
        // list.add(294);
        // list.add(1006);
        // list.add(292);
        // list.add(14);
        // list.add(29);
        // list.add(100);
        // list.add(29);
        // System.out.println(list);
        
        // list.set(0, 98);
        // list.remove(1);

        // System.out.println(list);


// Multiple Array list

        // Scanner input = new Scanner(System.in);
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         // list.get(i).add(input.nextInt());
        //     }
        // }
        int[] arr1=new int[]{3,6,8,9,2,5};
        swap(arr1, 4, 2);
        for (int i=0;i<arr1.length;i++ ) {
            System.out.println(arr1[i] + " ");
        }
    }
    static void swap(int[] arr,int ind1,int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;

    }
}