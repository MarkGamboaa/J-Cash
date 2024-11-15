public class Transaction {
    private String transactionType; // "Deposit" or "Withdraw"
    private int amount;
    private int accountNo;

    public Transaction(String transactionType, int amount, int accountNo) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountNo = accountNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void displayTransaction() {
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Account Number: " + accountNo);
    }
}
