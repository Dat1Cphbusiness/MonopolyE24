public class Player {

    private String name;
    private int balance;
    private final static int startBalance = 30000;
    private int position;
    private Account account;

    public Player(String name) {
        this.name = name;
        this.balance = startBalance;
        this.account = null;
    }


    public int updatePosition(int value) {
        if (position + value > 40) {
            position = position + value - 40;
            recieve(4000);
        } else {
            position = position + value;
        }
        return position;
    }


    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }

    public String getName() {
        return name;
    }


    public void recieve(int amount) {
        amount = 4000;
        account.deposit(amount);
    }
}
