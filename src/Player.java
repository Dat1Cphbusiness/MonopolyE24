import java.util.ArrayList;

public class  Player {
    private String name;
    private ArrayList<Field> deeds;
    private Account account;
    private int position;

    public Player(String name, int balance){
        this.name = name;

        deeds = new ArrayList<>();


        this.account = new Account(balance);
        this.setBalance(balance);
    }

    private void setBalance(int balance) {
        this.account.deposit(balance);
    }

    public String toString(){
        return this.name +", "+this.account.getBalance();
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value){
        this.position += value;
        return position;
    }
}
