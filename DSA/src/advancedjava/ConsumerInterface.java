package advancedjava;

import java.util.function.Consumer;
import java.util.function.Predicate;

//represents an operation that takes input and returns nothing.
public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<Integer> c =n -> System.out.println(n);
        c.accept(10);


        //Predicate<Integer> p = n -> n >=60;
        //System.out.println(p.test(60));
        //make a fraud transaction function using predicate

        Predicate<Integer> transaction_amount = t -> t >= 7700000;
        String trans = (transaction_amount.test(6000000)) ? "Fraud" : "Normal transaction : Not Fraud";
        System.out.println("The transaction is " + (trans) );

    }

}
