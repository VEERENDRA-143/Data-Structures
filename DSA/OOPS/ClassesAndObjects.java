class Student {
    int rolno;
    String name;
    float marks;

    Student() {
        // this.rolno = 20;
        // this.name = "Veeru";
        // this.marks = 32.4f;

        // calling other constructer 
        this(3,5);
    }

    Student(int x, int y) {
        System.out.println(x + y);
    }
}

public class ClassesAndObjects {

    public static void main(String[] args) {
        Student obj = new Student();
        // System.out.println(obj.rolno);
        System.out.println(obj.name);
        // System.out.println(obj.marks);

        // Student obj1 = new Student(2, 4);
    }
}