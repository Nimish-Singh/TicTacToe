package model;

public enum Symbol {
    X("X"), O("O"), EMPTY("-");

    private String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
