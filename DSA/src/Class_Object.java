public class Class_Object {
    int a =90; // non static
    void hello()//non static
    {
        System.out.println("this is non static");
    }

    static void hii()// static
    {
        System.out.println(" this is static");
    }

    public static void main(String[] args) {
        int b =67; //static variable
        Class_Object co1 = new Class_Object();
        //non static
        System.out.println(co1.a);
        co1.hello();
        //static
        System.out.println(b);
        hii();

    }
}

// object : to allocate memory
// constructor : default , parameterized
//constructor has same name as the class ; methods have different name