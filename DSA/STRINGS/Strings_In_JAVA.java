public class Strings_In_JAVA {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a==b); // True  


        String name1 = new String("hello");
        String name2 = new String("hello");
        System.out.println(name1 == name2); // False  (It Compares the Object references)
        System.out.println(name1.equals(name2)); // True (It Comparees the values of the vairable(objects))
        System.out.println(name1.charAt(3));
    }
}
