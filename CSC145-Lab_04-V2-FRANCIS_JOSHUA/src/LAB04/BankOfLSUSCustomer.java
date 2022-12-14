/*
 * File: BankOfLSUSCustomer.java
 * Author: Joshua Francis
 * Concentration: SD
 * Date: 11/15/2022
 * Java class description: Holds the Methods for Passing to BankOfLSUS For Calculating.
 * Data is Passed in From the BankOfLSUSDriver class.
 */

// Package
package LAB04;

// Imports
import java.util.Random; // For Creating The Random customerSinceYear for Each Customer
import java.time.*; // Handles Current Year for Customer Output

// Class
public class BankOfLSUSCustomer {

    // Local Variables
    String accountNumber = "";
    String firstName = "";
    String middleName = "";
    String lastName = "";
    String phoneNumber = "";
    int customerSinceYear = -Integer.MAX_VALUE;
    double accountBalance = -Double.MAX_VALUE;

    // Objects
    Random random = new Random(); // Random Object For Creating customerSinceYear For Customer

    // Constructor
    public BankOfLSUSCustomer(String[] data, int earliestYear) {
        // Makes Variables For The Data Passed in From the String Object From the BankOfLSUSDriver Class
        // Sets the Local Variables Equal to the Variables I Passed in From BankOfLSUSDriver
        accountNumber = data[0];
        firstName = data[1];
        middleName = data[2];
        lastName = data[3];
        phoneNumber = data[4];
        accountBalance = Double.parseDouble(data[5]); // Parses to a Double From a String at First Oppurtunity

        // Timing Object and Variables For Random Year For Customers
        Year currentYear = Year.now();
        customerSinceYear = random.nextInt((Integer.parseInt(currentYear.toString())
                - earliestYear) + 1) + earliestYear;
    }

    // Methods - For Use In Passing to BankOfLSUS Class Methods

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Sets the Customer's First Name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Sets the Customer's Middle Name
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Sets the Customer's Last Name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Sets the Customer's Phone Number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Sets the Year the Customer Joined the Bank
    public void setCustomerSinceYear(int customerSinceYear) {
        this.customerSinceYear = customerSinceYear;
    }

    // Sets the Customer's Account Balance
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Getters
    // Returns the Customer's Account Number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Returns the Customer's First Name
    public String getFirstName() {
        return firstName;
    }

    // Returns the Customer's Middle Name
    public String getMiddleName() {
        return middleName;
    }

    // Returns the Customer's Last Name
    public String getLastName() {
        return lastName;
    }

    // Returns the Customer's Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Returns the Year the Customer Joined the Bank
    public int getCustomerSinceYear() {
        return customerSinceYear;
    }

    // Returns the Customer's Account Balance
    public double getAccountBalance() {
        return accountBalance;
    }

    // Returns The Content Of All Objects
    @Override
    public String toString() {
        String Output = "";
        Output += "[" + accountNumber + "," + firstName + "," + middleName
                + "," + lastName + "," + phoneNumber + "," + accountBalance + "]\n";
        return Output;
    }
}
