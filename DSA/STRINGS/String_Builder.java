

public class String_Builder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder);
        builder.delete(1, 9);
        System.out.println(builder);
        System.out.println(builder.toString());
    }
}
