import exception.TicTacToeException;
import io.Output;
import model.Game;
import model.Symbol;

public class Main {
    public static void main(String[] args) {
        Output output = Output.CONSOLE;
        Game game = new Game(output);

        simulateGame2(game);
        simulateGame1(game);
    }

    private static void simulateGame2(Game game) {
        game.addPlayer(Symbol.X, "Gaurav");
        game.addPlayer(Symbol.O, "Sagar");

        game.playMove(2, 3);
        game.playMove(1, 2);
        game.playMove(2, 2);
        game.playMove(2, 1);
        game.playMove(1, 1);
        game.playMove(3, 3);
        game.playMove(3, 2);
        game.playMove(3, 1);
        game.playMove(1, 3);
    }

    private static void simulateGame1(Game game) {
        game.addPlayer(Symbol.X, "Gaurav");
        game.addPlayer(Symbol.O, "Sagar");

        game.playMove(2, 2);
        game.playMove(1, 3);
        game.playMove(1, 1);
        game.playMove(1, 2);
        game.playMove(2, 2);
        game.playMove(3, 3);
    }
}
