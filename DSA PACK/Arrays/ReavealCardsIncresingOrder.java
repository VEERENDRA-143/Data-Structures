import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReavealCardsIncresingOrder {
    public static void main(String[] args) {
        int[] deck = {1,1000};
        deckRevealedIncreasing(deck);
    }
    public static void deckRevealedIncreasing(int[] deck) {
        
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        int[] ans = new int[deck.length];
        int inde=0;
        int refer = 0;

        while (!queue.isEmpty()) {

            if (refer%2 == 0) {
                // System.out.println(queue.poll());
                int index =  queue.poll();
                ans[index] = deck[inde++];
                // System.out.println(refer +" "+ans[refer]);
            }
            else{
                int ele = queue.poll();
                queue.add(ele);
                // System.out.println(refer +" "+ele);
            }
            System.out.println();
            System.out.print("pass "+refer+" => ");
            for (int i : queue) {
                System.out.print(i+" ");
            }
            refer++;
        }

        System.out.println("Ans = "+Arrays.toString(ans));

    }
}
