package Assignment03;

import java.util.Date;

public abstract class Account {
    private int id;
    private String firstName;
    private String lastName;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    // No-argument constructor
    public Account() {
        this.dateCreated = new Date();
    }

    // Constructor with input parameters
    public Account(int id, String firstName, String lastName, double balance) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBalance(balance);
        this.dateCreated = new Date();
    }

    // Setter methods
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Abstract methods for withdrawal and deposit
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    // Overridden toString method
    @Override
    public String toString() {
        return "Account ID: " + id + "\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Balance: $" + balance + "\n" +
               "Annual Interest Rate: " + annualInterestRate + "%\n" +
               "Monthly Interest Rate: " + getMonthlyInterestRate() + "%\n" +
               "Date Created: " + dateCreated + "\n";
    }
}

