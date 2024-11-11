public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount < this.balance) {
            this.balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }
}
