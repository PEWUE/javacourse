public class Account {
    private final Person person;
    private double amount;

    public Account(Person person, double amount) {
        this.person = person;
        this.amount = amount;
    }

    public boolean deposit(double amountToDeposit) {
        amount += amountToDeposit;
        return true;
    }

    public boolean withdrawal(double amountToWithdrawal) {
        if (amountToWithdrawal > amount) {
            return false;
        }
        amount -= amountToWithdrawal;
        return true;
    }

    public boolean transfer(Account account, double amountToTransfer) {
        if (amountToTransfer > amount) {
            return false;
        }
        return account.deposit(amountToTransfer);
    }

    public void update() {
        System.out.println("Rachunek podstawowy");
    }

    public Person getPerson() {
        return person;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account [" + amount + "] - " + person;
    }
}