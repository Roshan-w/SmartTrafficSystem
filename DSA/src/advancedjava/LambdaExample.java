package advancedjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employeee {
    int id;
    String name;
    double salary;

    Employeee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        List<Employeee> list = Arrays.asList(
                new Employeee(1, "Roshan", 50000),
                new Employeee(2, "Sujal", 40000),
                new Employeee(3, "Virendra", 80000)
        );

        Employeee highest = list.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .orElse(null);


        System.out.println("Highest Salary: " + highest.name);

        System.out.println("\nEmployees sorted by salary:");
        list.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .map(e -> e.salary )
                .forEach(n->System.out.println(n));

        System.out.println("\nNames sorted by salary:");
        list.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .map(e -> e.name)
                .forEach(System.out::println);
    }
}


//work on employee data , take a data of 5 employees and print the highest salary and arrange the employee name in a chronological order according to their salary