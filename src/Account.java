public class Account {
    private int balance;
    private final static int startBalance = 30000;

    public Account (){
        this.balance = startBalance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }
    public boolean withdraw (int amount){
        if (amount > balance){
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}
