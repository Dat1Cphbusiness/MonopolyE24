public class Player {

    private String name;
    private int balance;
    private final static int startBalance = 30000;
    private int position;
    Account account;

    public Player (String name){
        this.name = name;
        account = new Account();
        this.startAmount = startAmount;


    }

    public void receive(int amount) {
        account.deposit(amount);
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String toString(){
        return this.name + ", "+ account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value) {
        if(position > 0) {
           receive(startAmount);
        }
        this.position = value;
        return value;
    }
}
