package advancedjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Orders{
    int id;
    String name;
    double amount;
    double rating;
    double distance;

    Orders(int id, String name, double amount, double rating, double distance) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.rating = rating;
        this.distance = distance;
    }
    Orders(int id , String name , double amount){
        this.id= id;
        this.name=name;
        this.amount=amount;
    }
}

public class OrderService {
    public static void main(String[] args) {
        List<Orders> orders = Arrays.asList(
                new Orders(1,"Rahul",600,4.5,3),
                new Orders(2,"Priya",300,4.2,2),
                new Orders(3,"Amit",800,3.8,6),
                new Orders(4,"Neha",1200,4.7,8)
        );





        List<Orders> finalOrders =orders.stream()
                .filter(o -> o.amount>500 && o.rating>=4)
                .map(o-> {
                    double discount =(o.distance<5) ? 0.10 : 0.05;
                    double finalAmount = o.amount - (o.amount*discount);
                    return new Orders(o.id, o.name, finalAmount);

                })
                .toList();


        for (Orders summary : finalOrders) {
            System.out.println(summary.id + " || " + summary.name + " || " +summary.amount );
        }


    }
}

//apply the concept of stream in tax deduction problem , now u change the code as per the requirement of the customer