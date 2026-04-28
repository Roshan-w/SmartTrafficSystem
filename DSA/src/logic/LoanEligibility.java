package logic;

public class LoanEligibility {
    public static void main(String[] args) {
        int salary = 30000;
        int creditScore = 800;
        int age = 30;
        boolean alreadyLoan = true;
        double emipercentage = 60;
        boolean transactions = true;

        if(alreadyLoan) {
            if (emipercentage > 50) {
                System.out.println("Loan Rejected: already loaned with 50 % of the salary");
            } else {
                //System.out.println("Loan Approved");

                if (transactions == false) {
                    System.out.println("Loan rejected : NO Transactions");

                } else if (creditScore < 0 || salary < 0) {
                    System.out.println("Loan Rejected: credit or salary is negative");
                } else {
                    if (salary >= 25000 && creditScore >= 700 && age >= 21 && age <= 60) {
                        System.out.println("Loan Approved");
                    } else {
                        System.out.println("Loan Rejected");
                    }
                }


            }
        }}}


//make 2 category : 1) a person is already having loan. 2)This person haven't began any transaction yet.