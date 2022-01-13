package task.controllers;

import task.models.Card;
import task.models.Farmer;

import java.util.Random;

public class GameController {

    private static Card[] cards;
    Random random = new Random();

    public void init(){
        Card card1 = new Card("Произошло нашествие саранчи." +
                "\nВы можете избавиться от саранчи используя инсектициды. Хотите ли? (y/n): ",
                new int[]{0,1,-5,-5,-1,0},
                "Вы успешно изгнали саранчу от посева!",
                "Саранча подпортила ваш урожай, но некритично.");
        Card card2 = new Card("Пришли кочевники." +
                "\nОни просят у вас немного лишней еды. Хотите поделиться? (y/n): ",
                new int[]{0,1,0,0,-1,0},
                "Один из кочевников назвал Вас 'добрая душа' =)",
                "Главный кочевник кивнул и они продолжили свой путь.");
        Card card3 = new Card("Засуха." +
                "\nРастениям и животным нужно больше воды. Купить воды? (y/n): ",
                new int[]{10,5,-10,-10,-5,0},
                "Вы помогли животным и растениям не умереть от жажды!",
                "Растения сохнут, животные убегают с фермы. Но завтра будет новый день.");
        Card card4 = new Card("Прибыл торговец удобрениями." +
                "\nХотите продать ему свои удобрения? (y/n): ",
                new int[]{-5,0,5,0,0,0},
                "Торговец: 'Отличные удобрения!'",
                "Торговец: 'Может, в другой раз?'");
        Card card5 = new Card("Прибыл перекупщик." +
                "\nОн хочет купить у вас корову. Продадите? (y/n): ",
                new int[]{-10,0,15,0,0,0},
                "Перекупщик: 'Спасибо!'",
                "Перекупщик: 'Я еще вернусь.'");
        Card card6 = new Card("Сегодня отличный день." +
                "\nХотите выпить молока с медом? (y/n): ",
                new int[]{0,5,0,0,0,0},
                "'После стакана молока и работать легче!'",
                "'Оставлю на потом.'");
        Card card7 = new Card("Проходя мимо грядок вы видите пару сорняков." +
                "\nВыполоть? (y/n): ",
                new int[]{5,0,0,-5,0,0},
                "'Отличная работа!'",
                "'В другой раз.'");
        Card card8 = new Card("Вы очень хотите мармелад." +
                "\nКупить? (y/n): ",
                new int[]{0,15,-10,0,-15,0},
                "Вы счастливы!",
                "'А так хотелось...'");
        Card card9 = new Card("Сегодня день полива." +
                "\nПолить грядки? (y/n): ",
                new int[]{10,0,0,-10,0,0},
                "Вы полили грядки.",
                "Вы решили полить грядки позже.");
        Card card10 = new Card("Время кормежки." +
                "\nПокормить животных? (y/n): ",
                new int[]{10,0,0,-10,0,0},
                "Вы покормили животных.",
                "Вы решили покормить животных позже.");
        cards = new Card[]{card1,card2,card3,card4,card5,card6,card7,card8,card9,card10};
    }
    public Card getRandomCard(){
        return cards[random.nextInt(10)];
    }
    public void step(Farmer player, Card card, boolean decision){
        if(decision){
            player.farmHealth+=card.effects[0];
            player.selfMood+=card.effects[1];
            player.money+=card.effects[2];
        } else {
            player.farmHealth+=card.effects[3];
            player.selfMood+=card.effects[4];
            player.money+=card.effects[5];
        }
        player.daysLeft--;
    }
}
