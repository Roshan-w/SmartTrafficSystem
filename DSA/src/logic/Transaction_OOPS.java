package logic;

class Account{
    //used encapsulation
    private double balance;
    public Account(double balance){
        this.balance = balance;
    }

    //Getter for Balance
    public double getBalance(){
        return balance;
    }

    //Validating whether the account has sufficient balance i,e balance >= amount
    public boolean sufficientbalance(double amount){
        return balance >= amount;
    }

    //Deducting the amount from the balance , i.e, balance = balance - amount
    public void deduct(double amount){
        if (amount <= balance){
            balance = balance - amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class Transaction{
    //used encapsulation
    private double amount;
    private double charge;
    private double dailyLimit;

    //constructor to set vars
    public Transaction(double amount,  double dailyLimit){
        this.amount= amount;
        this.dailyLimit = dailyLimit;
        this.charge = 0;
    }

    //Validation to check for amount > balance , dailylimit
    public boolean validate(Account account)
    {
        if (amount > account.getBalance())
        {
            System.out.println("Insufficient Balance");
            return false;
        }
        else if (amount > dailyLimit)
        {
            System.out.println("Daily limit exceeded");
            return false;
        }
        return true;
    }

    // Calculation of Charges if amount > 10000
    public void calculateCharge()
    {
        if(amount > 10000)
        {
            charge = amount * 0.02;
        }
    }

    //Getter for Total Amount
    public double getTotalAmount()
    {
        return amount + charge;
    }

    //Getter for Charges
    public double getCharge()
    {
        return charge;
    }

}



public class Transaction_OOPS {
    public static void main(String[] args) {
        Account account = new Account(12000);
        Transaction transaction = new Transaction(10001, 15000);

        if (transaction.validate(account))
        {
            transaction.calculateCharge();
            double totalAmount = transaction.getTotalAmount();

            if(account.sufficientbalance(totalAmount))
            {
                account.deduct(totalAmount);

                System.out.println("Transaction Approved");
                System.out.println("Charges applied: "+ transaction.getCharge());
                System.out.println("Total Deducted: " + totalAmount);
                System.out.println("Balance : "+ account.getBalance());
            }
        }

    }

}
