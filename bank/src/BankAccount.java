public class BankAccount extends Account {
    public static double bankAccountInterestRate = 2.9;

    public BankAccount(Person person, double amount) {
        super(person, amount);
    }

    public static void changeInterestRate(double newInterestRate) {
        bankAccountInterestRate = newInterestRate;
    }

    @Override
    public void update() {
        double interest = getAmount() * (bankAccountInterestRate / 100);
        setAmount(getAmount() + interest);
    }

    @Override
    public String toString() {
        return "BankAccount [" + getAmount() + "]"
                + "(" + bankAccountInterestRate + "%) - "
                + getPerson();
    }
}
