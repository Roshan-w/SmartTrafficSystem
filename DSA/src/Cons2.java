public class Cons2 {
    int i;
    float m;
    String n;

    Cons2(int id, String name, float marks)
    {
        this.i=id;
        this.n=name;
        this.m=marks;
    }
    void display()
    {
        System.out.println("Student Name: "+ n);
        System.out.println("Student Id: "+ i);
        System.out.println("Student Marks: "+ m);
    }

    public static void main(String[] args) {
        Cons2 c11 = new Cons2(101,"Roshan",93.80f);
        c11.display();
        System.out.println("------------------");
        Cons2 c12 = new Cons2(102,"Virendra",98.8f);
        c12.display();
        }
}
