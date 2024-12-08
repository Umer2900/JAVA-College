class BankAccount 
{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String[] transactionHistory;
    private int transactionCount;

    // Constructor to initialize the bank account
    public BankAccount(String accountNumber, String accountHolder, double initialBalance, int maxTransactions) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new String[maxTransactions];
        this.transactionCount = 0;
        recordTransaction("Account created with balance: ₹" + initialBalance);
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposited: ₹" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Cannot withdraw more than the available balance.");
        } else {
            balance -= amount;
            recordTransaction("Withdrew: ₹" + amount);
        }
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Method to record each transaction in the transaction history
    private void recordTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = transaction;
            transactionCount++;
        } else {
            System.out.println("Transaction history is full.");
        }
    }

    // Method to display the transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + " (" + accountNumber + "):");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
    }
}


class BankAccountManagement 
{
    public static void main(String[] args) 
    {
        // Create multiple bank account instances
        BankAccount account1 = new BankAccount("123456", "Umer", 500.00, 10);
        BankAccount account2 = new BankAccount("789101", "Ahmed", 1000.00, 10);

        // Perform some operations on the accounts
        account1.deposit(200);
        account1.withdraw(150);
        account1.checkBalance();
        account1.displayTransactionHistory();

        account2.deposit(300);
        account2.withdraw(1200);  // Insufficient funds
        account2.checkBalance();
        account2.displayTransactionHistory();
    }
}
