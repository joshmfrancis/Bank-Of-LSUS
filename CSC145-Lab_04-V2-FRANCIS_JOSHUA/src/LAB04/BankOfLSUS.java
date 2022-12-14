/*
 * File: BankOfLSUS.java
 * Author: Joshua Francis
 * Concentration: SD
 * Date: 11/15/2022
 * Java class description: Holds the Methods for Making Changes to Customer Account.
 * Data is Passed in From the BankOfLSUSCustomer class.
 */

// Package
package LAB04;

// Imports
import java.text.DecimalFormat; // Handles Currency Conversion for Outputing and Method Calls
import java.time.*; // Handles Current Year for Customer Output

// Class
public class BankOfLSUS {

    // Objects - Imported
    DecimalFormat dollarFmt = new DecimalFormat("$0.00"); // Decimal Formatter for Currency
    DecimalFormat intRateFmt = new DecimalFormat("0.00%"); // Decimal Formatter for Interest Rate Printing in addInterest Method
    Year currentYear = Year.now(); // Current Year Object

    // Local Variables
    private final double RATE = 0.0375; // Interest Rate of 3.75%
    String acctNumber;
    String firstName;
    String middleName;
    String lastName;
    String phoneNumber;
    int customerSinceYear;
    double balance;
    int earliestYear = 1970; // Earliest Year Someone Could Have Joined the Bank

    // public so I can access the count of the array
    public BankOfLSUSCustomer[] arrayOfBankCustomers = null;
    int customerIndex = 0;

    // Constructor
    public BankOfLSUS(int numCustomers) {
        this.arrayOfBankCustomers = new BankOfLSUSCustomer[numCustomers];
    }

    // Methods
    // Method to create a new Customer, and add it to the Array of Customers - also passes earliestYear to BankOfLSUSCustomer Class for
    public void addCustomer(String[] customerData) {
        arrayOfBankCustomers[customerIndex] = new BankOfLSUSCustomer(customerData, earliestYear);
        customerIndex++;
    }

    // Returns an Index of the Array of Customers, for use in the Driver Class to Specify Which Customer is Taking Action on Their Account
    public BankOfLSUSCustomer customer(int index) {
        return arrayOfBankCustomers[index];
    }

    // Returns a Formatted Output of Customer Details for the User to Read
    public String snapshot(BankOfLSUSCustomer customer) {
        String snapshot = "";
        // If the Customer Doesn't Have A Middle Name...
        if ("".equals(customer.getMiddleName())) {
            // Don't Print it!

            // Adds to the "Running Output" for Type of Data
            snapshot += "Account #:\tFirst Name:\tLast Name:\tPhone #:\tAccount Held Since:\tYears Of Loyality:\tAccount Balance:\n";
            // Data - Pulled from BankOfLSUSCustomer Class, as I did not Pass This Through the Constructor
            snapshot += customer.getAccountNumber() + "\t" + customer.getFirstName()
                    + "\t\t" + customer.getLastName() + "\t\t" + customer.getPhoneNumber()
                    + "\t\t" + customer.getCustomerSinceYear() + "\t\t\t" + getLoyality(customer)
                    + "\t\t\t" + dollarFmt.format(customer.getAccountBalance()) + "\n";
            // Returns to be Printed
            return snapshot;
            // Else if the Customer Does Have A Middle Name...
        } else {
            // Print it!
            // Adds to the "Running Output" for Type of Data
            snapshot += "Account #:\tFirst Name:\tMiddle Name:\tLast Name:\tPhone #:\tAccount Held Since:\tYears Of Loyality:\tAccount Balance:\n";
            // Data - Pulled from BankOfLSUSCustomer Class, as I did not Pass This Through the Constructor
            snapshot += customer.getAccountNumber() + "\t" + customer.getFirstName()
                    + "\t\t" + customer.getMiddleName() + "\t\t" + customer.getLastName()
                    + "\t\t" + customer.getPhoneNumber() + "\t\t" + customer.getCustomerSinceYear()
                    + "\t\t\t" + getLoyality(customer) + "\t\t\t"
                    + dollarFmt.format(customer.getAccountBalance()) + "\n";
        }
        // Returns to be Printed
        return snapshot;
    }

    // Methods
    // Deposits the Specified Amount Into Account. Returns the new Balance. - Specifies the customer by passing it in through the customer Method in This Class.
    public double deposit(BankOfLSUSCustomer customer, double amount) {
        System.out.println("Current Balance: " + dollarFmt.format(customer.getAccountBalance()));
        System.out.println("Depositing " + dollarFmt.format(amount) + "...");
        balance = customer.getAccountBalance() + amount;
        customer.setAccountBalance(balance);
        System.out.println("Balance Updated: " + dollarFmt.format(customer.getAccountBalance()));
        return balance;
    }

    // Withdraws the Specified Amount From the Account and Applies the fee (Currently set to 0 for all!). Returns the new Balance. - Specifies the customer by passing it in through the customer Method in This Class.
    public double withdraw(BankOfLSUSCustomer customer, double amount, double fee) {

        // Prints out the Current Balance to the Console Formatted From the BankOfLSUSCustomer Class
        System.out.println("Current Balance: " + dollarFmt.format(customer.getAccountBalance()));
        // If the Customer has Enough Funds to Withdraw...
        if (customer.getAccountBalance() >= amount + fee) {
            // Progress Message for the User
            System.out.println("Withdrawing " + dollarFmt.format(amount) + "...");
            // Withdraw!
            balance = customer.getAccountBalance() - amount - fee;
            // Sets the Balance to the Customer's Current Balance
            customer.setAccountBalance(balance);
            // Prints out the Updated Balance to the Console Formatted From the BankOfLSUSCustomer Class
            System.out.println("Balance Updated: " + dollarFmt.format(customer.getAccountBalance()));
        } else {
            // Don't Withdraw!
            // Progress Message for the User
            System.out.println("Withdrawing " + dollarFmt.format(amount) + "...");
            // Error Message for the User
            System.out.println("***** ERROR: INSUFFICIENT FUNDS *****");
            // Gets the Balance from the Customer's Current Balance
            balance = customer.getAccountBalance();
            // Prints out the Current Balance to the Console Formatted From the BankOfLSUSCustomer Class
            System.out.println("Balance Not Updated: " + dollarFmt.format(customer.getAccountBalance()));
        }
        // Returns the Balance to be Printed
        return balance;
    }

    // Adds Interest to the Account and Returns the new Balance.
    public double addInterest(BankOfLSUSCustomer customer) {
        // Prints out the Current Balance to the Console Formatted
        System.out.println("Current Balance: " + dollarFmt.format(customer.getAccountBalance()));
        // Progress Message for the User
        System.out.println("Adding Interest Rate of " + intRateFmt.format(RATE) + "...");
        // Calculates the Balance With the Interest Rate
        
        balance = (((customer.getAccountBalance()) * RATE)+ customer.getAccountBalance()) ;
        customer.setAccountBalance(balance);
        // Prints out the Updated Balance to the Console Formatted
        System.out.println("Balance Updated: " + dollarFmt.format(customer.getAccountBalance()));

        return balance; // Returns the Balance to be Printed
    }

    //  Returns the Current Balance of the Account.
    public double getBalance(BankOfLSUSCustomer customer) {
        // Progress Message for the User
        System.out.println("Current Balance:");
        // Gets the Balance from the Customer's Current Balance
        balance = customer.getAccountBalance();

        return balance; // Returns the Balance to be Printed
    }

    // Returns the Amount of Years the Customer has Been at the LSUS Bank.
    public int getLoyality(BankOfLSUSCustomer customer) {
        // Parses the currentYear to an Integer As It is a String and Needs to be Used For Operations in the BankOfLSUS Class Methods
        int currentYearInt = Integer.parseInt(currentYear.toString());
        int loyality = currentYearInt - customer.getCustomerSinceYear();
        return loyality;
    }

    // Returns an unformatted, look at all of the objects.
    @Override
    public String toString() {

        // Defaults the Output
        String Output = "";

        // For Loop to Loop Through the Customers 
        for (int customer = 0; customer < customerIndex; customer++) {
            // Prints out the Customers in the Array of Customers 
            Output += arrayOfBankCustomers[customer].toString() + "\n";
        }

        return Output;

    }
}
