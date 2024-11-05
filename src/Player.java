
public class Player {

    private String name;
    private int balance;
    public Player(String name, int startAmount) {
        this.name = name;
        this.balance = startAmount;
    }



    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance(){
        return this.balance;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }

}
