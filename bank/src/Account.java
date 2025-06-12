public class Account {
    private final Person person;
    private double amount;

    public Account(Person person, double amount) {
        this.person = person;
        this.amount = amount;
    }

    public boolean deposit(double amountToDeposit) {
        if (amountToDeposit <= 0) {
            return false;
        }
        amount += amountToDeposit;
        return true;
    }

    public boolean withdrawal(double amountToWithdrawal) {
        if (amountToWithdrawal > amount || amountToWithdrawal <= 0) {
            return false;
        }
        amount -= amountToWithdrawal;
        return true;
    }

    public boolean transfer(Account account, double amountToTransfer) {
        if (withdrawal(amountToTransfer)) {
            return account.deposit(amountToTransfer);
        }
        return false;
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