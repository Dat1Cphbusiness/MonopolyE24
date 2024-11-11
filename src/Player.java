public class Player {

    private String name;
    private int balance;
    private int position;
    private Account account;

    public Player (String name){
        this.name = name;
        this.balance = startBalance;
    }

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value){
        if (position+value > 40) {
            this.account.deposit(4000);
        }
        this.position += value;
        return this.position % 40;
    }

    public void receive(int amount){
        account.deposit(amount);
    }
}
