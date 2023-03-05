package model;

public class Cell {
    private int xCoordinate;
    private int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public boolean isValid() {
        return xCoordinate > 0 && xCoordinate < 4 && yCoordinate > 0 && yCoordinate < 4;
    }
}
