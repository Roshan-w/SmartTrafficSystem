package logic;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        int correctPassword = 1234;
        int attempts =3;

        System.out.print("Enter Password :");
        Scanner input = new Scanner(System.in);
        for(int i=0;i<attempts;i++){
            if(input.nextInt()==correctPassword){
                System.out.println("You have successfully logged in");
                break;
            }else{
                System.out.println("Incorrect password ");
            }

        }
    }
}
