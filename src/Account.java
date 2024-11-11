public class Account extends Player {
    int balance;

    public Account(String name) {
        super(name);
    }

    public Account(String name, int balance) {
        super(name, balance);
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public boolean withdraw(int amount) {
        this.balance -= amount;
        if (this.balance <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
