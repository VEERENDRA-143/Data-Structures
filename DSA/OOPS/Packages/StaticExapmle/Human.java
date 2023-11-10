package Packages.StaticExapmle;

class Human {
    int age;
    String name;
    int salary;
    boolean married;
    long population;

    static long static_popluation;

    Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        this.population += 1;
        Human.static_popluation += 1;
    }

}