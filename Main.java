package task;

import task.presentations.ConsoleView;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ConsoleView consoleView = new ConsoleView();
        consoleView.startGame();
    }
}
