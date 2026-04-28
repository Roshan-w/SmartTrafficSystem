import java.util.Scanner;

public class Main{
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter Your name");
       String name = input.nextLine();
       System.out.println("Enter Your Age");

       int age = input.nextInt();
       System.out.println("Enter Your Division");
       int div = input.nextInt();
       System.out.println("Enter Your CGPA");
       float cgpa = input.nextFloat();
       System.out.println("Your Intro:");
       System.out.println("My name is " + name+", i am "+age+" years old. My Division is "+div +". My CGPA is "+cgpa);
    }
}