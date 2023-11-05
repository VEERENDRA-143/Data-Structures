import java.util.ArrayList;

public class Dice {
    private int i=2;
    public static void main(String[] args) {
        System.out.println(NumberInDiceCount("", 4));
        NumberInDiceFaces("", 7, 8);
        
    }

    // Combinations To form a Number in Dice
    static void NumberInDice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i < 6 && i <= target; i++) {
            NumberInDice(p + i, target - i);
        }
    }

    // With the Array List
    static ArrayList<String> NumberInDiceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> li = new ArrayList<>();
        for (int i = 1; i < 6 && i <= target; i++) {
            li.addAll(NumberInDiceRet(p + i, target - i));
        }

        return li;
    }


    // Counting the No. Of Combinations
    static int NumberInDiceCount(String p, int target) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i < 6 && i <= target; i++) {
           count += NumberInDiceCount(p + i, target - i);
        }
        return count;
    }


    // Custome Faces
    static void NumberInDiceFaces(String p, int target,int faces) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i < faces && i <= target; i++) {
            NumberInDiceFaces(p + i, target - i,faces);
        }
    }

}
