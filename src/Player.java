public class Player {

    private String name;
    private int startAmount;
    private final static int startBalance = 30000;
    private int position;
    Account account;

    public Player (String name, int startAmount){
        this.name = name;
        account = new Account();
        this.startAmount = startAmount;


    }

    public void receive(int amount) {
        account.deposit(amount);
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
