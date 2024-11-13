public class Card {
private String message;
private int income;
private int cost;
private String event;
private int moveToPosition;

    public Card(String message, int income, int cost, String event, int moveToPostion) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
        this.moveToPosition = moveToPostion;
    }

    public String getMessage() {
        return message;
    }

    public static int getIncome() {
        return income;
    }

    public static int getCost() {
        return cost;
    }

    public String getEvent() {
        return event;
    }

    public static int getMoveToPosition() {
        return moveToPosition;
    }
}
