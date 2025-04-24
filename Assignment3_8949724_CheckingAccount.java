package Assignment03;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    // Constructor with input parameters
    public CheckingAccount(int id, String firstName, String lastName, double balance, double overdraftLimit) {
        super(id, firstName, lastName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Setter method for overdraft limit
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // Getter method for overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {
        if (getBalance() == -overdraftLimit) {
            throw new IllegalArgumentException("Cannot withdraw. Balance has reached the overdraft limit.");
        } else if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        } else if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Transaction successful. New balance: " + getBalance());
        } else {
            throw new IllegalArgumentException("Withdrawal exceeds available balance plus overdraft limit: " + (getBalance() + overdraftLimit));
        }
    }

    // Override deposit method
    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Transaction successful. New balance: " + getBalance());
        }
    }

    // Overridden toString method
    @Override
    public String toString() {
        return super.toString() + "Account Type: Checking\n" +
               "Overdraft Limit: $" + overdraftLimit + "\n";
    }
}
