public class Player {

    private String name;
    private int position;
    Account account;

    public Player (String name){
        this.name = name;
        this.position = 0;
        this.account = new Account();
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value) {

        if (position < 40 && position+value > 40){
            receive(4000);
        }

        return position += value;
    }

    public void receive(int amount){
        account.deposit(amount);
    }
}
