public class Player {

    private String name;
    private int balance;
    private int position;
    private int prevPosition;
    private final static int startBalance = 30000;

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

    public int getPrevPosition() {
        return prevPosition;
    }

    public int updatePosition(int result) {
        prevPosition = position;
        this.position += result;
        return position%40;
    }   // end updatePosition()

}
