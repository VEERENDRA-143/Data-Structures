import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {

   
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadderI o = new WordLadderI();

        System.out.println(o.ladderLength(beginWord, endWord, wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        while (!queue.isEmpty()) {
            String str = queue.peek().word;
            int curLen = queue.peek().len;
            if (str.equals(endWord)) {
                return curLen;
            }
            queue.remove();
            for (int i = 0; i < str.length(); i++) {
                for(char ch = 'a';ch <= 'z'; ch++){
                    char replacedArray[] = str.toCharArray();
                    replacedArray[i] = ch;
                    String replacedString = new String(replacedArray);
                    if (set.contains(replacedString)) {
                        set.remove(replacedString);
                        queue.add(new Pair(replacedString, curLen+1));
                    }
                }
            }

        }
        return 0;
    }

    class Pair {
    
        String word;
        int len;

        public Pair(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }
}
