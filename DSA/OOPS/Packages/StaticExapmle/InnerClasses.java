package Packages.StaticExapmle;

public class InnerClasses {
    static class Test{
        String name;
        public Test(String name){
            this.name = name;
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Test ob = new Test("veeru");
        Test ob2 = new Test("ram");
    }
}
