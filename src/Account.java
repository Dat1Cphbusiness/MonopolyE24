public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }


    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance = balance -amount;

            return true;
        } else {
         //System.out.println("Not enough money in account");
            return false;
        }
    }

        public int getBalance (){
            return balance;
        }
}