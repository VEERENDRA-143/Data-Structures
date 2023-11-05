import java.util.ArrayList;

public class IntersctionOfTwoArrys {
    public static void main(String[] args) {
        int[] arr1 = { 4, 9, 5 };
        int[] arr2 = { 9, 4, 9, 8, 4 };
        System.out.println(intersection(arr1, arr2));
    }

    static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> newarr = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    newarr.add(arr1[i]);
                }
            }
        }
        for (int i = 0; i < newarr.size(); i++) {
            for (int j = 0; j < newarr.size(); j++) {
                if (newarr.get(i)==newarr.get(j)) {
                    newarr.remove(i);
                }
            }
        }
        
        return newarr;
    }
}
