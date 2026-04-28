package advancedjava;
import java.util.Arrays;
import java.util.List;
class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id     = id;
        this.name   = name;
        this.salary = salary;
    }
}
public class TransactionValidation {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sujal",  30000),
                new Employee(2, "Roshan",  75000),
                new Employee(3, "Poornima",   50000),
                new Employee(4, "Virendra",   20000),
                new Employee(5, "Honey", 100000)
        );
        System.out.println("Employees with tax less than 20%");
        employees.stream()
                .filter(e -> getTax(e.salary) < 20)
                .map(e -> {
                    double taxPercent = getTax(e.salary);
                    double taxAmount  = e.salary * (taxPercent / 100);
                    double netSalary  = e.salary - taxAmount;
                    return "ID:" + e.id + " | " + e.name +
                            " | Salary: " + e.salary +
                            " | Tax: "     + taxPercent + "%" +
                            " | Net: "   + netSalary;
                })
                .forEach(System.out::println);
    }
    static double getTax(double salary) {
        if (salary < 30000) return 0;
        else if (salary <= 70000) return 10;
        else return 20;
    }
}