import java.util.HashMap;
import java.util.Map;

public class HandOfStrights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        isNStraightHand(hand, groupSize);
    }
    public static void isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            System.out.println("false");
            return;
        }
        // counting frequencies
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (freq.containsKey(hand[i])) {
                freq.put(hand[i], freq.get(hand[i])+1);
            }
            else{
                freq.put(hand[i], 1);
            }
        }

        while (freq.size()  > 0 ) {
            int current_card = freq.entrySet().iterator().next().getKey();
            System.out.println(current_card);
            for (int i = 0; i < groupSize; i++) {
                if (!freq.containsKey(current_card+i)) {
                    return;
                }
                freq.put(current_card+i, freq.get(current_card+i)-1);
                if (freq.get(current_card+i) == 0) {
                    freq.remove(current_card+i);
                }
            }
        }
        System.out.println(freq);

    }
}
