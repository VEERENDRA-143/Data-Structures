
// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.


public class ValidWord {
    public static void main(String[] args) {
        String word = "aya";
        System.out.println(isValid(word));
    }
    
    public static boolean isValid(String word) {
        int vowels =0;
        int consonents = 0;
        for(char ele : word.toCharArray()){
            if (Character.isLetter(ele)) {
                if ("aeiouAEIOU".indexOf(ele)!=-1) {
                    vowels++;
                }
                else{
                    consonents++;
                }
            }
            else{
                if (!Character.isDigit(ele)) {
                    return false;
                }
            }
        }
        return vowels>=1 && consonents>=1;
        
    }
    
}
