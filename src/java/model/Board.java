package model;

import exception.TicTacToeException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Symbol>> grid;

    public Board() {
        grid = new ArrayList<>();
        grid.add(0, new ArrayList<>());
        grid.add(1, new ArrayList<>());
        grid.add(2, new ArrayList<>());

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                grid.get(row).add(column, Symbol.EMPTY);
            }
        }
    }

    public void nextMove(Player player, Cell cell) throws TicTacToeException {
        if (!cell.isValid()) {
            throw new TicTacToeException("Cell value is out of range");
        }

        if (!Symbol.EMPTY.equals(grid.get(cell.getXCoordinate() - 1).get(cell.getYCoordinate() - 1))) {
            throw new TicTacToeException("Invalid move");
        }

        grid.get(cell.getXCoordinate() - 1).set(cell.getYCoordinate() - 1, player.getSymbol());
    }

    public List<List<Symbol>> getCurrentState() {
        return List.copyOf(grid);
    }

    public boolean hasPlayerWon(Player player) {
        return (hasWonRowWise(player) || hasWonColumnWise(player) || hasWonDiagonally(player));
    }

    private boolean hasWonRowWise(Player player) {
        for (int row = 0; row < 3; row++) {
            if (player.getSymbol().equals(grid.get(row).get(0)) &&
                player.getSymbol().equals(grid.get(row).get(1)) &&
                player.getSymbol().equals(grid.get(row).get(2))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasWonColumnWise(Player player) {
        for (int column = 0; column < 3; column++) {
            if (player.getSymbol().equals(grid.get(0).get(column)) &&
                player.getSymbol().equals(grid.get(1).get(column)) &&
                player.getSymbol().equals(grid.get(2).get(column))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasWonDiagonally(Player player) {
        if (player.getSymbol().equals(grid.get(0).get(0)) &&
            player.getSymbol().equals(grid.get(1).get(1)) &&
            player.getSymbol().equals(grid.get(2).get(2))) {
            return true;
        }
        return player.getSymbol().equals(grid.get(0).get(2)) &&
            player.getSymbol().equals(grid.get(1).get(1)) &&
            player.getSymbol().equals(grid.get(2).get(0));
    }
}
