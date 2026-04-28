public class Constructor_001 {
    void cons()
    {
        System.out.println("this is a method");
    }

    // default Constructor
    Constructor_001()
    {
        System.out.println("this is constructor...");
    }

    //Parameterized Constructor
    Constructor_001(int a, int b, int c)
    {
        System.out.println("Value of a , b , c :" +a+" "+b+" "+c);
    }

    public static void main(String[] args) {
        Constructor_001 c1 = new Constructor_001(4,5,6); //constructor calling
        Constructor_001 c2 = new Constructor_001();
        c1.cons(); // method calling

    }
}
