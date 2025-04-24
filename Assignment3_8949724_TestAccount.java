package Assignment03;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TestAccount {
    private static final double ANNUAL_INTEREST_RATE = 4.5;
    private static final double OVERDRAFT_LIMIT = 2000.0;
    private static final double TRANSACTION_FEE = 2.0;

    public static void main(String[] args) {
        Account.setAnnualInterestRate(ANNUAL_INTEREST_RATE); // Set the annual interest rate for all accounts
        Scanner input = new Scanner(System.in); // Scanner for user input

        int savingsAccountId = 0;
        int checkingAccountId = 0;
        String firstName = null;
        String lastName = null;
        double checkingBalance = 0;
        double savingsBalance = 0;
        boolean validInput = false;

        // Collect user input
        while (!validInput) {
            try {
                if (savingsAccountId == 0) {
                    savingsAccountId = validateInt(input, "Enter Savings Account ID: ");
                }
                if (checkingAccountId == 0) {
                    checkingAccountId = validateInt(input, "Enter Checking Account ID: ");
                }
                if (firstName == null) {
                    firstName = validateString(input, "Enter First Name: ");
                }
                if (lastName == null) {
                    lastName = validateString(input, "Enter Last Name: ");
                }
                if (checkingBalance == 0) {
                    checkingBalance = validateDouble(input, "Enter Checking Balance: ");
                }
                if (savingsBalance == 0) {
                    savingsBalance = validateDouble(input, "Enter Savings Balance: ");
                }

                // Create the CheckingAccount and SavingsAccount
                CheckingAccount checkingAccount = new CheckingAccount(checkingAccountId, firstName, lastName, checkingBalance, OVERDRAFT_LIMIT);
                SavingsAccount savingsAccount = new SavingsAccount(savingsAccountId, firstName, lastName, savingsBalance, TRANSACTION_FEE);

                // Perform operations
                performOperations(input, checkingAccount, savingsAccount);

                // Print final account summaries
                printAccountSummary(checkingAccount, savingsAccount);

                validInput = true; // Input successfully validated
            } catch (InputMismatchException ime) {
                System.out.println(ime.getMessage());
                input.next(); // Discard invalid input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Method for performing operations like withdrawal, deposit, etc.
    public static void performOperations(Scanner input, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        boolean continueOperations = true;
        while (continueOperations) {
            try {
                // Display menu options
                System.out.println("Select an operation:\n1 - Withdraw from Savings\n2 - Deposit into Savings\n3 - Withdraw from Checking\n4 - Deposit into Checking\n5 - Print Account Statement\n6 - Exit");
                int option = validateInt(input, "Choose an option: ");
                double amount;

                // Switch case to handle different options
                switch (option) {
                    case 1:
                        amount = validateDouble(input, "Enter amount to withdraw from Savings: ");
                        savingsAccount.withdraw(amount); // Perform withdrawal
                        break;
                    case 2:
                        amount = validateDouble(input, "Enter amount to deposit into Savings: ");
                        savingsAccount.deposit(amount); // Perform deposit
                        break;
                    case 3:
                        amount = validateDouble(input, "Enter amount to withdraw from Checking: ");
                        checkingAccount.withdraw(amount); // Perform withdrawal
                        break;
                    case 4:
                        amount = validateDouble(input, "Enter amount to deposit into Checking: ");
                        checkingAccount.deposit(amount); // Perform deposit
                        break;
                    case 5:
                        printAccountSummary(checkingAccount, savingsAccount); // Print account details
                        break;
                    case 6:
                        continueOperations = false; // Exit the loop
                        System.out.println("Exiting application and printing the final account summary.");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                }
            } 
            
      //exceptional handling for input mis-match
            catch(InputMismatchException ime) { System.out.println(ime.getMessage());
            System.out.println("----Returning to the operation selection----"); input.next();
            //exceptional handling for illegal arguments.
            }catch (IllegalArgumentException iae) { System.out.println(iae.getMessage());
            System.out.println("----Returning to the operation selection----");
            }
         }
      }

    // Method to validate and get an integer input
    public static int validateInt(Scanner input, String prompt) {
        System.out.print(prompt);
        if (!input.hasNextInt()) {
            throw new InputMismatchException("Invalid input. Please enter a valid integer.");
        }
        int value = input.nextInt();
        if (value >= 0) {
            return value;
        }
        throw new InputMismatchException("Invalid input. Please enter a positive integer.");
    }

    // Method to validate and get a string input
    public static String validateString(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.next().trim();
    }

 // Method to validate and get a double input
    public static double validateDouble(Scanner input, String prompt) {
        double amount;
        while (true) {
            System.out.print(prompt);
            // Check if the next input is a valid double
            if (!input.hasNextDouble()) {
                throw new InputMismatchException("Invalid input. Please enter a valid integer.");
            }
            amount = input.nextDouble();
            // Check if the amount is positive
            if (amount >= 0) {
                return amount; // Return the valid input
            } else {
                throw new InputMismatchException("Amount cannot be negative. Please enter a valid positive number.");
            }
        }
    }

    // Method to print account summary
    public static void printAccountSummary(CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        System.out.println("Accounts Balance Summary:");
        System.out.println(checkingAccount); // Print Checking account details
        System.out.println(savingsAccount); // Print Savings account details
    }
}

