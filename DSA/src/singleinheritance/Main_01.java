package singleinheritance;

public class Main_01
{

    public static void main(String[] args) {
        Father f1 = new Father();
        f1.parent(); // child class
        System.out.println(f1.a); // father(child) class variable
        //parent class variable or method
        f1.grant_011();
        System.out.println("Grand parent age:");
        f1.showgrandvalue();

        System.out.println("----------");
        Employee e = new Employee();
        e.works();
        e.work();
        e.printids();
    }
}
