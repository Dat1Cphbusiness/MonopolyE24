public class Card {
    private String message;
    private int income;
    private int cost;
    private String event;

    Card(String message, int income, int cost, String event) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Message: " + message + " Income: " + income + " Cost: " + cost + " Event: " + event;
    }

    public int getCost() {
        return cost;
    }

    public int getIncome() {
        return income;
    }

    public String getEvent() {
        return event;
    }

    public String getMessage() {
        return message;
    }
}
