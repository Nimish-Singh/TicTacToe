package model;

import exception.TicTacToeException;
import io.Output;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private boolean isPlayer1Turn;
    private Output output;
    private int totalMoves;

    public Game(Output output) {
        this.board = new Board();
        this.output = output;
        totalMoves = 0;
        players = new ArrayList<>(2);
        isPlayer1Turn = true;
    }

    public void addPlayer(Symbol symbol, String name) {
        Player player = new Player(name, symbol);
        players.add(player);
    }

    public void playMove(int xCoordinate, int yCoordinate) {
        Cell cell = new Cell(xCoordinate, yCoordinate);
        Player currentPlayer = isPlayer1Turn ? players.get(0) : players.get(1);

        try {
            board.nextMove(currentPlayer, cell);
        } catch (TicTacToeException e) {
            output.print(e.getMessage());
            output.print("\n");
            return;
        }

        totalMoves++;
        printBoard();

        if (board.hasPlayerWon(currentPlayer)) {
            output.print(currentPlayer.getName() + " won the game");
            System.exit(0);
        }

        if (totalMoves == 9) {
            output.print("Game Over");
            System.exit(0);
        }
        isPlayer1Turn = !isPlayer1Turn;
    }

    private void printBoard() {
        List<List<Symbol>> boardState = board.getCurrentState();
        for (List<Symbol> symbols : boardState) {
            for (int column = 0; column < 3; column++) {
                output.print(symbols.get(column).getValue() + " ");
            }
            output.print("\n");
        }
        output.print("\n");
    }
}
