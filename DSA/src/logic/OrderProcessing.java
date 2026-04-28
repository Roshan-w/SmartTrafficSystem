package logic;

import java.util.Scanner;

public class OrderProcessing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String[] products = {"TV", "Mobile", "Laptop", "Tablet"};
        int[] prices = {25000, 20000, 50000, 10000};

        System.out.print("Enter the number of products to add: ");
        int n = input.nextInt();

        int[] cart = new int[n];
        int total = 0;
        double finaltotal;

        System.out.println("Enter The product to add in cart: ");
        System.out.println("[0] for TV");
        System.out.println("[1] for Mobile");
        System.out.println("[2] for Laptop");
        System.out.println("[3] for Tablet");
        System.out.println("[9] for Exit");

        //Taking Input and adding items to cart
        for (int i = 0; i < n; i++) {
            int choice = input.nextInt();

            if (choice == 9) {
                System.out.println("EXIT");
                break;
            } else if (choice >= 0 && choice < products.length) {
                cart[i] = choice;
                total += prices[choice];
                System.out.println(products[choice] + " added to cart.");
            } else {
                System.out.println("Invalid choice!!");
                i--;
            }
        }

        //Coupon logic
        if(total >= 25000 && total < 50000){
            System.out.println("Total Price Before Discount: "+total);
            System.out.println("Coupon of Rs. 500 Applied!!");
            total -=500;
        } else if (total >= 50000 && total < 100000) {
            System.out.println("Total Price Before Discount: "+total);
            System.out.println("Coupon of Rs. 1000 Applied!!");
            total -=1000;
            }
        else if (total >= 100000) {
            System.out.println("Total Price Before Discount: "+total);
            System.out.println("Coupon of Rs. 2000 Applied!!");
            total -=2000;
        }


        if(total>0){
        System.out.println("Total Price after Discount : " + total);
        finaltotal = total + (total*0.18);
        System.out.println("Total Price with GST: " + finaltotal);
        }
        else{
            System.out.println("Cart Empty");
        }
        input.close();
    }
}

//The concepts that i have used are :
// 1) Scanner Class 2)For Loop 3)Arrays