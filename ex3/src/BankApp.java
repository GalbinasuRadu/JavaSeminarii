public class BankApp {

    public static void main(String[] args) {

        try {

            BankAccount account1 =
                    new BankAccount("Radu", 1000);

            SavingsAccount savings1 =
                    new SavingsAccount("Ana", 2000, 0.05);

            account1.displayInfo();

            account1.deposit(500);

            account1.withdraw(300);

            account1.displayInfo();

            savings1.addInterest();

            // Test invalid deposit
            account1.deposit(-100);

            // Test insufficient funds
            account1.withdraw(5000);

        } catch (InvalidAmountException e) {

            System.out.println("Invalid Amount Error: " + e.getMessage());

        } catch (InsufficientFundsException e) {

            System.out.println("Insufficient Funds Error: " + e.getMessage());

        }
    }
}