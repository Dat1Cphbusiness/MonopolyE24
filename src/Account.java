public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }


    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public boolean hasSufficientFunds(int amount){
        if (balance >= amount) {
            return true;
        } else {
            return false;
        }
    }
    public boolean withdraw(int amount) {
        if (hasSufficientFunds(amount)) {
            balance = balance -amount;
            return true;
        } else {
            return false;
        }
    }

        public int getBalance (){
            return balance;
        }
}