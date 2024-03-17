import java.util.HashMap;
import java.util.Map;

public class UniqueNoOfOccurence {
    public static void main(String[] args) {
        
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int a:arr){
            if(hm.containsKey(a)){
                int cnt = hm.get(a);
                hm.put(a,cnt+1);
            }else{
                hm.put(a,1);
            }
        }
        long c = hm.values().stream().distinct().count();
        
        return c==hm.size()?true:false;
    }
}
