// import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostprofitAssingWork {
    
    public static void maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < difficulty.length; i++) {
            int[] arr = new int[2];
            arr[0] = difficulty[i];
            arr[1] = profit[i];
            list.add(arr);
        }
        Arrays.sort(worker);
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        int netproft = 0;
        int maxProfit = 0;
        int index = 0;

        for (int i = 0; i < worker.length; i++) {
            while (index < difficulty.length && worker[i] >= list.get(index)[0]) {
                maxProfit = Math.max(maxProfit, list.get(index)[1]);
                index++;
            }
            netproft+=maxProfit;
        }

        System.out.println(netproft);
    }
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit= {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        maxProfitAssignment(difficulty, profit, worker);
    }
}
