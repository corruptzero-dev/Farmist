package task.presentations;

import task.controllers.GameController;
import task.models.Card;
import task.models.Farmer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleView {
    Farmer player = new Farmer();
    GameController gc = new GameController();
    Scanner scanner = new Scanner(System.in);
    public void startGame() throws FileNotFoundException {
        System.out.println("Добро пожаловать в Farmist.");
        gc.init();
        while (player.isOk(player)) {
            System.out.printf("\n-- Осталось дней: %d --\nСостояние фермы: %d\nНастроение: %d\nФинансы: %d\n\n",
                    player.daysLeft,
                    player.farmHealth,
                    player.selfMood,
                    player.money);
            Card card = gc.getRandomCard();
            System.out.printf("%s\n%s", card.title, card.description);
            boolean decision = scanner.next().equalsIgnoreCase("y");
            gc.step(player, card, decision);
            System.out.println(decision ? card.positive : card.negative);
            if (player.daysLeft == 0) break;
        }
        player.gameOver(player);
    }
}
