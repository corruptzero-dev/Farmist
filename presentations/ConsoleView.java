package task.presentations;

import task.controllers.GameController;
import task.models.Card;
import task.models.Farmer;

import java.util.Scanner;

public class ConsoleView {
    Farmer player = new Farmer();
    GameController gc = new GameController();
    Scanner scanner = new Scanner(System.in);
    public void startGame(){
        System.out.println("Добро пожаловать в Farmist.");
        gc.init();
        while (player.money>0&&player.money<100&&player.selfMood>0&&player.selfMood<100&&player.farmHealth>0&&player.farmHealth<100){
            System.out.printf("\n-- Осталось дней: %d --\nСостояние фермы: %d\nНастроение: %d\nФинансы: %d\n\n",
                    player.daysLeft,
                    player.farmHealth,
                    player.selfMood,
                    player.money);
            Card card = gc.getRandomCard();
            System.out.print(card.description);
            boolean decision = scanner.next().equalsIgnoreCase("y");
            gc.step(player,card,decision);
            System.out.println(decision?card.positive:card.negative);
            if(player.daysLeft==0) break;
        }
        if(player.daysLeft==0){
            System.out.println("Вы ушли на пенсию! Отличная работа.");
        } else {
            System.out.println("\nВы проиграли. Причина:");
            if(player.selfMood<=0){
                System.out.printf("Вам стало очень грустно и вы решили молча уехать.\nНастроение(%d) <= 0", player.selfMood);
            } else if(player.selfMood>=100){
                System.out.printf("Вы познали смысл жизни и решили стать отшельником.\nНастроение(%d) >= 100", player.selfMood);
            } else if (player.farmHealth<=0){
                System.out.printf("Вы запустили ферму. Больше никто не хочет покупать у вас что-либо.\nСостояние фермы(%d) <= 0", player.farmHealth);
            } else if (player.farmHealth>=100){
                System.out.printf("Ферма стала слишком процветающей и у вас отняли её силой.\nСостояние фермы(%d) >= 100", player.farmHealth);
            } else if (player.money<=0){
                System.out.printf("У вас не осталось денег на корм животным и семена.\nФинансы(%d) >= 100", player.money);
            } else if (player.money>=100){
                System.out.printf("Вы молча улетели на Сейшелы.\nФинансы(%d) <= 0", player.money);
            } else {
                throw new Error("Что-то пошло не так.");
            }
        }
    }
}
