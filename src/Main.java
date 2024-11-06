
class Main {

    public static void main(String[] args) {

        Game game = new Game("Matador");
        game.setup();

        System.out.print(game);

        game.endSession();
    }
}