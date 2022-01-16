package task.controllers;

import com.google.gson.stream.JsonReader;
import task.models.Card;
import task.models.Farmer;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class GameController {

    private static Card[] cards;
    Gson gson = new Gson();
    Random random = new Random();

    public void init() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("src/task/cards.json"));
        cards = gson.fromJson(reader, Card[].class);
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
