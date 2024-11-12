import java.util.ArrayList;

public class Player {

    private String name;
    private int position;
    Account account;
    ArrayList<Field> deeds = new ArrayList<Field>();
    Board board;

    public Player (String name){
       this(name, 0);
    }

    public Player (String name, int startAmount){
        this.name = name;
        this.position = 1;
        this.account = new Account();
        account.deposit(startAmount);
    }

    public String toString(){
        return this.name + ", "+ this.account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value) {
        // if we pass Start
        if (position+value > 40){
            receive(4000);
            position = (position + value) - 40;
        }
        else{
            position += value;
        }
        return position;
    }

    public void receive(int amount){
        account.deposit(amount);
    }

    boolean pay(int amount){
        return account.withdraw(amount);
    }

    boolean pay(int amount, Player recipient){
        if (pay(amount)){
            recipient.receive(amount);
            return true;
        }
        return false;
    }

    public boolean buyProperty(Field f){
       boolean result = pay(f.cost);
            if(result){
                //If person has the funds to buy property it is added to their deed list
                deeds.add(f);
                return true;
            }
            return false;
    }



    public int getWorthInCash(){
        return account.getBalance();
    }

    public int getTotalWorth(){
        int sum = 0;
        for (int i = 0; i < deeds.size(); i++) {
            sum = sum + deeds.get(i).cost;
        }
        return sum + getWorthInCash();
    }

    public void moveToPrison(){
        int distance = board.getField(31).id-position;
        updatePosition(distance);
    }
}
