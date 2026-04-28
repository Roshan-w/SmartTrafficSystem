package logic;

public class SalaryProcessing {
    public static void main(String[] args) {
        int salary = 80000;

        if(salary < 30000)
        {
            System.out.println("Tax : 0 ");
            System.out.println("Initial Salary : "+salary);
            System.out.println("Net Salary after deduction : "+salary);

        }
        else if(salary >= 30000 && salary < 70000)
        {
            double tax = (0.1 * salary);
            System.out.println("Initial Salary : "+salary);
            System.out.println("Tax :" + tax);
            System.out.println("Net Salary after deduction : "+(salary-tax));
        }else{
            double tax = (0.2 * salary);
            System.out.println("Initial Salary : "+salary);
            System.out.println("Tax :" + tax);
            System.out.println("Net Salary after deduction : "+(salary-tax));
    }
}}

//