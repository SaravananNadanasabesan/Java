package Assignment03;

public class SavingsAccount extends Account {
    private double transactionFee;

    // Constructor with input parameters
    public SavingsAccount(int id, String firstName, String lastName, double balance, double transactionFee) {
        super(id, firstName, lastName, balance);
        this.transactionFee = transactionFee;
    }

    // Setter method for transaction fee
    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    // Getter method for transaction fee
    public double getTransactionFee() {
        return transactionFee;
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        } else if (amount + transactionFee <= getBalance()) {
            setBalance(getBalance() - amount - transactionFee);
            System.out.println("Transaction successful. New balance: " + getBalance());
        } else {
            throw new IllegalArgumentException("Insufficient funds including transaction fee.");
        }
    }

    // Override deposit method
    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        } else {
            setBalance(getBalance() + amount - transactionFee);
            System.out.println("Transaction successful. New balance: " + getBalance());
        }
    }

    // Overridden toString method
    @Override
    public String toString() {
        return super.toString() + "Account Type: Savings\n" +
               "Transaction Fee: $" + transactionFee + "\n";
    }
}
