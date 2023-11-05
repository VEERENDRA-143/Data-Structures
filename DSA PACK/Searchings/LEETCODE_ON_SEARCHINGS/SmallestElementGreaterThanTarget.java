public class SmallestElementGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));

    }
    public static char nextGreatestLetter(char[] letters, char target) {
        for(char ch: letters){
            if(ch >target) {
                return ch;
            }
        } 
		return letters[0];
    }
}
