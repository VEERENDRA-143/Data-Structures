import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"",""};
        groupAnagrams(strs);
    }
    public static void  groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        int j=0;
        for (String string : strs) {
            System.out.println(string);
            List<String> list = new ArrayList<>();
            
            if (!visited[j] ) {
                list.add(string);
                for (int i = j+1; i < strs.length; i++) {
                    boolean check = checkAnagram(string,strs[i]);
                    if (check && !visited[i]) {
                        // System.out.print(strs[i]+" ");
                        visited[i] = true;
                        list.add(strs[i]);
                    }
                }
                ans.add(list);
                System.out.println(list);
            }
            j++;
        }

    }
    private static boolean checkAnagram(String target,String string) {
        
        for (int i = 0; i < target.length(); i++) {
            if (string.indexOf(target.charAt(i))<0) {
                return false;
            }
        }

        return true;
    }
}
