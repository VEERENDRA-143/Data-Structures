import java.util.*;
public class PermutationSequence {
    public static void main(String[] args) {
        // Permutations_String("", "abcd");
        int n = 3;
        int k = 3;
        getPermutation(n, k);
    
    }
    
    public static void getPermutation(int n, int k) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        List<String> list = new ArrayList<>();
        Permutations_String("",s,list);
        System.out.println(list);
        System.out.println("ans= " +" " +list.get(list.size()-k));

    }
    public static void Permutations_String(String p, String up,List<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            Permutations_String(s + ch + f, up.substring(1),list);
        }
    }

    public static void gen(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        getPermutation(0, nums,new ArrayList<>(), ans);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static void getPermutation(int index,int[] arr,List<Integer> subset,List<List<Integer>> ans){
        if (index >= arr.length) {
            ans.add(new ArrayList<Integer>(subset));
            return;
        }

        subset.add(arr[index]);
        getPermutation(index+1, arr, subset, ans);
        subset.remove(subset.size()-1);
        getPermutation(index+1, arr, subset, ans);
    }
}

