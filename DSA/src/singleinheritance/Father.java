package singleinheritance;

public class Father extends Grand_parent
{
    int a = 34;
    void parent()
    {
        System.out.println("I am your Father");
    }
    void showgrandvalue()
    {
        System.out.println(super.a);
    }
}
