/*
 * File: BankOfLSUSDriver.java
 * Author: Joshua Francis
 * Concentration: SD
 * Date: 11/15/2022
 * Java class description: Driver Class For Reading the Data and Applying the
 * Methods From the BankOfLSUS Class That Uses the BankOfLSUSCustomer Class.
 * Passes in a CSV for input that holds customer data, and uses the methods in the
 * other classes to modify it. This class calls the other classes to do so.
 * This project mimics a banking system that pulls from a CSV.
 */

// Package
package LAB04;

// Imports
// For Reading in the File, Throwing Exceptions For Common File Errors, and Logging to Console for Those Errors
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Class
public class BankOfLSUSDriver {

    // Main Method
    public static void main(String[] args) throws IOException {

        // Path of CSV File
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory + "/src/LAB04/Customers.csv";

        String line = ""; // Defaults Line to "Null"

        // Creates a BankOfLSUS Object to Hold 32 BankOfLSUSCustomer Objects
        BankOfLSUS bank = new BankOfLSUS(32);

        // Try Catch Throws a FileNotFoundException if the File is not Found OR Throws a IOException if the Line is Read Improperly
        // Tries...
        BufferedReader Parse = new BufferedReader(new FileReader(path));
        try {

            // While the BufferedReader Reads a Line and it is not Empty...
            while ((line = Parse.readLine()) != null) {
                // Split That Line of Data and Create a String Array of it
                String[] data = line.split(",");
                bank.addCustomer(data);
            }
            // Catches the Error and Reports it to the Console if the File is not Found
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BankOfLSUSDriver.class.getName()).log(Level.SEVERE, null, ex);
            // Catches the Error and Reports it to the Console if the Line Reader Hits any Issues
        } catch (IOException ex) {
            Logger.getLogger(BankOfLSUSDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 20 Transactions: (6 Unique Customers, 7 in Total) (Each Performs Different Operations on Their Account)
        // I only Heavily Comment The First Customer's (One of Each Type of Transaction) Transactions, as it is Tedious to do all of Them
        // Customer #1: (Transactions 1,2,3,4)
        // Printing Out the Customer In Line
        System.out.println("-----Customer #1-----");
        System.out.println(bank.snapshot(bank.customer(0)));

        // Transaction #1:
        System.out.println("Transaction #1:");
        // Withdraws $40000 by Calling the withdraw Method From the BankOfLSUS Class, Specifying the Customer and the Amount to be Deposited. (Receives This Data From the BankOfLSUSCustomer Class)
        bank.withdraw(bank.customer(0), 40000, 0);

        System.out.println(); // Spacing

        // Transaction #2:
        System.out.println("Transaction #2:");
        bank.withdraw(bank.customer(0), 10000, 0);

        System.out.println(); // Spacing

        // Transaction #3:
        System.out.println("Transaction #3:");
        bank.withdraw(bank.customer(0), 1000000000, 0);

        System.out.println(); // Spacing

        // Transaction #4:
        System.out.println("Transaction #4:");
        // Deposits $1000000 by Calling the deposit Method From the BankOfLSUS Class, Specifying the Customer and the Amount to be Withdrawn. (Receives This Data From the BankOfLSUSCustomer Class)
        bank.deposit(bank.customer(0), 1000000);

        System.out.println(); // Spacing

        // Test Of Interest Rate #1:
        System.out.println("Interest Rate #1:");
        // Adds Interest (3.75%) by Calling the addInterest Method From the BankOfLSUS Class, Specifying the Customer.
        bank.addInterest(bank.customer(0));

        System.out.println("\n"); // Spacing



        // Customer 2: (Transactions 5,6,7,8)
        System.out.println("-----Customer #2-----");
        System.out.println(bank.snapshot(bank.customer(4)));


        // Test Of Interest Rate #2:
        System.out.println("Interest Rate #2:");
        bank.addInterest(bank.customer(4));

        System.out.println(); // Spacing

        // Transaction #5:
        System.out.println("Transaction #5:");
        bank.deposit(bank.customer(4), 564736.45);

        System.out.println(); // Spacing

        // Transaction #6:
        System.out.println("Transaction #6:");
        bank.withdraw(bank.customer(4), 674674.57, 0);

        System.out.println(); // Spacing

        // Transaction #7:
        System.out.println("Transaction #7:");
        bank.withdraw(bank.customer(4), 27438347, 0);

        System.out.println(); // Spacing

        // Transaction #8:
        System.out.println("Transaction #8:");
        bank.deposit(bank.customer(4), 8348346);

        System.out.println("\n"); // Spacing



        // Customer 3: (Transactions 9,10,11,12)
        System.out.println("-----Customer #3-----");
        System.out.println(bank.snapshot(bank.customer(3)));


        // Transaction #9:
        System.out.println("Transaction #9:");
        bank.withdraw(bank.customer(3), 1234.56, 0);

        System.out.println(); // Spacing

        // Transaction #10:
        System.out.println("Transaction #10:");
        bank.deposit(bank.customer(3), 34.56);

        System.out.println(); // Spacing

        // Test Of Interest Rate #3:
        System.out.println("Interest Rate #3:");
        bank.addInterest(bank.customer(3));

        System.out.println(); // Spacing

        // Transaction #11:
        System.out.println("Transaction #11:");
        bank.withdraw(bank.customer(3), 5056.90, 0);

        System.out.println(); // Spacing

        // Transaction #12:
        System.out.println("Transaction #12:");
        bank.withdraw(bank.customer(3), 50000, 0);

        System.out.println("\n"); // Spacing

        // Customer 4: (Transactions 13,14,15)
        System.out.println("-----Customer #4-----");
        System.out.println(bank.snapshot(bank.customer(15)));

        // Transaction #13:
        System.out.println("Transaction #13:");
        bank.withdraw(bank.customer(15), 79406, 0);

        System.out.println(); // Spacing

        // Transaction #14:
        System.out.println("Transaction #14:");
        bank.deposit(bank.customer(15), 100.25);

        System.out.println(); // Spacing

        // Test Of Interest Rate #4:
        System.out.println("Interest Rate #4:");
        bank.addInterest(bank.customer(15));

        System.out.println(); // Spacing

        // Transaction #15:
        System.out.println("Transaction #15:");
        bank.withdraw(bank.customer(15), 2700.73, 0);

        System.out.println("\n"); // Spacing

        // Customer 5: (Transactions 16,17)
        System.out.println("-----Customer #5-----");
        System.out.println(bank.snapshot(bank.customer(31)));

        // Transaction #16:
        System.out.println("Transaction #16:");
        bank.withdraw(bank.customer(31), 50345435, 0);

        System.out.println(); // Spacing

        // Transaction #17:
        System.out.println("Transaction #17:");
        bank.deposit(bank.customer(31), 4567.56);

        System.out.println(); // Spacing

        // Test Of Interest Rate #5:
        System.out.println("Interest Rate #5:");
        bank.addInterest(bank.customer(31));

        System.out.println("\n"); // Spacing

        //REPEAT CUSTOMER :)
        // Customer 6: (Transactions 18,19)
        System.out.println("-----Customer #6-----");
        System.out.println(bank.snapshot(bank.customer(4)));

        // Transaction #18:
        System.out.println("Transaction #18:");
        bank.deposit(bank.customer(4), 10000000);

        System.out.println(); // Spacing

        // Transaction #19:
        System.out.println("Transaction #19:");
        bank.withdraw(bank.customer(4), 67673.45, 0);

        System.out.println(); // Spacing

        // Test Of Interest Rate #6:
        System.out.println("Interest Rate #6:");
        bank.addInterest(bank.customer(4));

        System.out.println("\n"); // Spacing

        // Customer 7: (Transaction 20)
        System.out.println("-----Customer #7-----");
        System.out.println(bank.snapshot(bank.customer(2)));

        // Test Of Interest Rate #7:
        System.out.println("Interest Rate #7:");
        bank.addInterest(bank.customer(2));

        System.out.println(); // Spacing

        // Transaction #20:
        System.out.println("Transaction #20:");
        bank.deposit(bank.customer(2), 58148.69);

        // Spacing
        System.out.println("\n");

        //Prints all customers formatted!\
        // For Loop to loop through all of the Customers In the Array of Customers 
        for (int counter = 0; counter < bank.arrayOfBankCustomers.length; counter++) {
            System.out.println("Content Of All Objects Formatted And Updated:");
            // Calls the snapshot Method to Print out the Formatted Customer 
            System.out.println(bank.snapshot(bank.customer(counter)));
        }

        // Displays The Contents Of All Objects Unformatted by using the bank toString Method 
        System.out.println("Content Of All Objects Unformatted:");
        System.out.println(bank);
    }
}
