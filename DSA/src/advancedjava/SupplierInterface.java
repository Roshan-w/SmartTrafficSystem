package advancedjava;
import java.util.*;

import java.util.function.Supplier;

public class SupplierInterface {
    static void main(String[] args) {
        Supplier<Integer> s =() -> 100;
        System.out.println(s.get());

        //Optional
        Optional<String> name = Optional.ofNullable("Roshan");
        System.out.println(name.orElse("Default Name"));

        //reduce method
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = list.stream()
                .reduce(0,(a,b) -> a+b);
        System.out.println("Sum is : " + sum);
    }
}
