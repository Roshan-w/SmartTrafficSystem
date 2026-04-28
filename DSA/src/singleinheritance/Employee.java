package singleinheritance;

public class Employee extends Manager
{
    int id = 5050;
    void work()
    {
        System.out.println("Developing .... ");
    }
    void printids()
    {
        System.out.println("Manager id "+ super.id);
        System.out.println("Employee id" + id);

    }
}
