public class BankAccountVIP extends BankAccount {
    private final double interestRate;
    private final double debitLimit;

    public BankAccountVIP(Person person, double amount, double interestRate, double debitLimit) {
        super(person, amount);
        this.interestRate = interestRate;
        this.debitLimit = debitLimit;
    }

    @Override
    public boolean withdrawal(double amountToWithdrawal) {
        if (amountToWithdrawal > getAmount() + debitLimit) {
            return false;
        }
        setAmount(getAmount() - amountToWithdrawal);
        return true;
    }

    @Override
    public boolean transfer(Account account, double amountToTransfer) {
        if (amountToTransfer > getAmount() - debitLimit) {
            return false;
        }
        account.deposit(amountToTransfer);
        return true;
    }

    @Override
    public void update() {
        if (getAmount() < 0) {
            throw new RuntimeException("Stan konta mniejszy od 0. Nie można doliczyć oprocentowania");
        }
        double currentAmount = getAmount();
        double interest = currentAmount * (interestRate / 100);
        setAmount(currentAmount + interest);
    }

    @Override
    public String toString() {
        return "BankAccountVIP [" + getAmount() + "]"
                + "(" + interestRate + "%, debet: ("
                + debitLimit + ") - "
                + getPerson();
    }
}
