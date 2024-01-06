package JavaAdvancedLab.DefeiningClasses.BankAccount;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccounts = 1;
    private int ID;
    private double balance;

    BankAccount() {
        this.ID = bankAccounts++;
        this.balance = 0;
    }

    public double getInterest (int years) {
        return this.balance * interestRate * years;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    void deposit (double amount) {
        this.balance += amount;
    }
    public int getID() {
        return this.ID;
    }
}
