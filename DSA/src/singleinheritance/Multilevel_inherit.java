package singleinheritance;
class Company_CEO // Parent 1
{
    String c_name ="Tata";
    void ceo(String name)
    {
        System.out.println("Company Name: "+c_name);
        System.out.println("CEO Name: "+name);
    }

}

class Business_head extends Company_CEO
{
    void BA()
    {
        System.out.println("Company Name: "+super.c_name);
        System.out.println("Business Development");
    }
}

class HR extends Business_head
{
    void hr_details(int id , String name)
    {
        System.out.println("HR ID: " +id);
        System.out.println("HR Name "+name);
    }
}


public class Multilevel_inherit {
    public static void main(String[] args) {
        HR h1 = new HR();
        h1.ceo("Roshan");
        System.out.println("--------------");
        h1.BA();
        System.out.println("--------------");
        h1.hr_details(101,"Virendra");

    }
}
