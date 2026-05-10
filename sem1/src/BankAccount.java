public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance) {

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdraw amount");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
    }

    public void displayInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
    }
}
