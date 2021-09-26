package activity7;

import java.math.BigDecimal;
import java.util.Scanner;

public class AutomatedTellerMachine {

    // Account class to store an account number and the balance
    static class Account {
        // account number field
        private String accountNumber;

        // balance field
        private BigDecimal balance;

        // constructor that initializes the account number. balance is zero
        public Account(String accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = BigDecimal.ZERO;
        }

        // setters and getters
        public String getAccountNumber() {
            return accountNumber;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }
    }


    public static void main(String[] args) {
        // Initialize our ATM class
        AutomatedTellerMachine atm = new AutomatedTellerMachine();
        // Initialize our account with an account number of 1
        Account myAccount = new Account("1");

        // Initialize isRunning flag to true
        boolean isRunning = true;

        // while isRunning is true
        while(isRunning) {
            // Display menu
            System.out.println("----------------------------------ATM----------------------------------\n1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. EXIT\n");

            // Initialize our Scanner
            Scanner sc = new Scanner(System.in);

            // prompt for choice
            System.out.print("Choose operation: ");
            // switch case for our choice
            switch ( sc.nextInt() ) {
                // If case = 1
                case 1:
                    // prompt for the amount to be withdrawn
                    System.out.print( "Enter amount to be withdrawn: " );
                    // Get the amount
                    BigDecimal amountToBeWithdrawn = sc.nextBigDecimal();
                    // call withdraw method that takes the account and amount
                    atm.withdraw( myAccount, amountToBeWithdrawn );
                    break;
                case 2:
                    // prompt for the amount to deposit
                    System.out.print( "Enter amount you want to deposit: " );
                    // get deposit amount
                    BigDecimal depositAmount = sc.nextBigDecimal();
                    // call deposit that takes the account and deposit amount
                    atm.deposit( myAccount, depositAmount);
                    break;
                case 3:
                    // prompt for the amount to transfer
                    System.out.print( "Enter amount you want to transfer: " );
                    // get the transfer amount
                    BigDecimal transferAmount = sc.nextBigDecimal();
                    // skip a line for the buffer
                    sc.nextLine();
                    // prompt for the account number
                    System.out.print( "Enter account number you want to transfer to: " );
                    // get the account number and store to variable
                    final String accountNumber = sc.nextLine();
                    // call transfer method passing in the account, account number and transfer amount
                    atm.transfer( myAccount, accountNumber, transferAmount );
                    break;
                case 4:
                    // Call check balance method passing in our account
                    atm.checkBalance(myAccount);
                    break;
                case 5:
                    // set isRunning to false and continue
                    isRunning = false;
                    continue;
                default:
                    // Error
                    System.out.println("ERROR. Please enter a valid choice.");
                    break;
            }

            // Prompt user if he/she wants to check balance
            System.out.print("Check Balance? 1. Yes\t0. No: ");
            int isCheck = sc.nextInt(); // get choice
            if( isCheck == 1) { // If it's 1 then proceed
                atm.checkBalance(myAccount); // call check balance method
            }

        }

    }


    /**
     * Withdraws the provided amount from the account
     * @param account
     * @param amount
     */
    public void withdraw( final Account account, final BigDecimal amount ) {

        // Validate if amount is zero, If so then display an error message
        if( amount.compareTo(BigDecimal.ZERO) == 0 ) {
            System.out.println("You can't withdraw an amount of zero.");
            return;
        }

        // Validate if the account has sufficient balance to begin the transaction
        if( account.getBalance().compareTo( amount ) < 0  ) {
            System.out.println("Insufficient Balance");
            return;
        }

        // deduct the amount from the account's balance
        account.setBalance( account.getBalance().subtract(amount) );

        // print message to user to collect the money
        System.out.println("Collect your money");
    }

    /**
     * Deposits the provided amount to the account
     * @param account
     * @param amount
     */
    public void deposit( final Account account, final BigDecimal amount ) {
        // Validate if the amount is zero or not. If so, then display an error and do not proceed with the transaction
        if( amount.compareTo(BigDecimal.ZERO) == 0 ) {
            System.out.println("You can't deposit an amount of zero.");
            return;
        }

        // Set new balance by adding the amount to the current balance
        account.setBalance( account.getBalance().add(amount) );
    }

    /**
     * Transfers the provided amount from the given account to another, given the account number
     * @param account
     * @param accountNumber
     * @param moneySent
     */
    public void transfer( final Account account, final String accountNumber, final BigDecimal moneySent ) {
        // Initialize the other account
        Account otherAccount = new Account(accountNumber);
        // Validate if the amount has sufficient balance. If it's insufficient, do not proceeed to transaction
        if( account.getBalance().compareTo(moneySent) <= 0 ) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Deduct the amount from the given account
        account.setBalance( account.getBalance().subtract(moneySent) );
        // Add the amount to the other account
        otherAccount.setBalance( otherAccount.getBalance().add(moneySent) );
        // print success message
        System.out.println("Transfer Successful");
    }

    /**
     * Method that prints the current balance of the account
     * @param account
     */
    public void checkBalance( final Account account ) {
        // Prints the balance
        System.out.println("Balance: " + account.getBalance().toPlainString());
    }
}
