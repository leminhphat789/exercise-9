public class Main {
    public static void main(String[] args) {
        GameModel model1 = GameModel.getInstance();
        GameModel model2 = GameModel.getInstance();

        System.out.println("Same GameModel instance: " + (model1 == model2));

        model1.newGame();
        System.out.println("Game 1 started.");

        model2.newGame();
        System.out.println("Game 2 started.");
        System.out.println("Same instance after newGame: "
                + (model1 == GameModel.getInstance()));
    }
}
