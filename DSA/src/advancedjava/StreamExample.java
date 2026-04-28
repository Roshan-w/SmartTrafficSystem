package advancedjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList();
        list.stream().filter(n -> n % 2 == 0).map(n -> n*2).forEach(name -> System.out.println(name));

    }
}
