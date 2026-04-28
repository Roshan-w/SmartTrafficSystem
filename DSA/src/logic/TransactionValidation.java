package logic;

public class TransactionValidation {
    public static void main(String[] args) {
        double balance = 10200;
        double amount = 10000;
        double dailylimit=15000;
        double charge = 0;


        //1) validation
        if (amount > balance)
        {
            System.out.println("Transaction Failed : Insufficient Balance");
        } else if (amount > dailylimit)
        {
            System.out.println("Transaction Failed : Daily Limit Exceeded");
        }
        else {
            //2) charge calculation
            if(amount >= 10000){
                charge = amount * 0.02;
            }
        }
         double totalamount = amount + charge;
         if (totalamount > balance){
             System.out.println("Transaction Failed : Insufficient Balance");
         }
         else
         {
             balance = balance - totalamount;


             //step3 ) output
            System.out.println("Transaction Approved");
            System.out.println("Charge Applied:"+ charge);
            System.out.println("Total Deducted: " + totalamount );
            System.out.println("Remaining Balance:"+ balance);
         }

    }
}

//verify at which step and how the concept of oops is being utilised and if it is not then define how it can be used at certain steps.