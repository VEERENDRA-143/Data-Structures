// import java.util.HashMap;

public class ContonousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            int zeros=0;
            int ones=0;
            for (int j = i; j < nums.length; j++) {
                if ( nums[j]==1) {
                    ones++;
                }
                else if(nums[j]==0){
                    zeros++;
                }
                else{
                    continue;
                }
                if (ones==zeros) {
                    
                    max = Math.max(max,j-i+1);
                    
                }
            }
        }
        return max;
    }
}


// Approch 2

// HashMap<Integer,Integer> map = new HashMap(); //difference - > index
//         map.put(0,-1);

//         int max_length = 0;
//         int count = 0 ;

//         for(int i = 0 ; i< nums.length ;i++){
//             if(nums[i] == 0){
//                 count += -1;
//             }else{
//                 count += 1;
//             }

//             if(map.containsKey(count)){
//                 max_length = Math.max(max_length,i-map.get(count));
//             }else{
//                 map.put(count,i);
//             }
//         }
//         return max_length;