public class Player {

    private String name;
    private Account account;
    private int position;
    private final static int startBalance = 30000;


    public Player (String name){
        this.name = name;
        this.account = account;
    }

    public Player(String name,Account account) {
        this.name = name;
        this.account = account;
    }

    public int updatePosition(int value, Board board) {
        this.position += value;
        if (position > board.getFieldSize()) {
            receive(4000);
            position -= board.getFieldSize();
        }
        return position;
    }

    public int getBalance() {
        return balance;
    }

    public String toString(){
        return this.name + ", "+ this.account;
    }

    public String getName() {
        return name;
    }
}
