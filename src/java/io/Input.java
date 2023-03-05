package io;

import java.util.Scanner;

public interface Input {
    Input CONSOLE = () -> new Scanner(System.in).nextLine();

    public String read();
}
