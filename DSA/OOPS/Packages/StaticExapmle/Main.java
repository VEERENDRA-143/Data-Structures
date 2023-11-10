package Packages.StaticExapmle;

public class Main {
    public static void main(String[] args) {
        Human veerendra = new Human(20, "Veeru", 10000, false);
        Human ram = new Human(23, "RAM", 20020, true);

        System.out.println(veerendra.name);

        System.out.println(veerendra.population);
        System.out.println(ram.population);

        System.out.println(veerendra.static_popluation);
        System.out.println(ram.static_popluation);

        System.out.println(Human.static_popluation);
    }
}

class Demo extends Main {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
