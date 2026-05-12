public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate)
            throws InvalidAmountException {

        super(owner, balance);

        this.interestRate = interestRate;
    }

    public void addInterest() {

        double interest = getBalance() * interestRate;

        System.out.println("Interest added: " + interest);
    }
}