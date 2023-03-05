package io;

public interface Output {
    Output CONSOLE = System.out::print;

    public void print(String message);
}
