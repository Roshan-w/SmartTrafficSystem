package advancedjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Order{
    int id;
    String name;
    double amount;
    double rating;
    double distance;

    Order(int id, String name, double amount, double rating, double distance) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.rating = rating;
        this.distance = distance;
    }
}

public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1,"Rahul",600,4.5,3),
                new Order(2,"Priya",300,4.2,2),
                new Order(3,"Amit",800,3.8,6),
                new Order(4,"Neha",1200,4.7,8)
        );



        orders.stream()
                .filter(o -> o.amount>500 && o.rating>=4)
                .map(o-> {
                    double discount =(o.distance<5) ? 0.10 : 0.05;
                    double finalAmount = o.amount - (o.amount*discount);
                    return String.format(" Dear %s , your order for order id %d is placed and the the final amount to be paid: %.2f ", o.name,o.id,o.amount);
                   // return o.id + "->" + o.name+"->"+finalAmount;
                })
                .forEach(System.out::println);
    }
}
