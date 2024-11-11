public class Player {

    private String name;
    private Account account;
    private int position;
    private final static int startBalance = 30000;
    private final static int passBonus = 4000;


    public Player (String name, Account account){
        this.name = name;
        this.account = account;
        account.deposit(startBalance);
    }

    public Player (String name, Account account, int value) {
        this.name = name;
        this.account = account;
        account.deposit(value);
    }

    public int updatePosition(int value) {
        this.position += value;
        if (position > Board.fieldSize) {
            receive(passBonus);
            position -= Board.fieldSize;
        }
        return position;
    }

    public void receive(int value) {
        account.deposit(value);
    }

    public String toString(){
        return this.name + ", " + account.getBalance();
    }

    public String getName() {
        return name;
    }
}
