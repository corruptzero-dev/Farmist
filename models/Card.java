package task.models;

public class Card {
    public final String description;
    public final int[] effects;
    public final String positive;
    public final String negative;
    public Card(String description, int[] effects, String positive, String negative) {
        this.description = description;
        this.effects = effects;
        this.positive = positive;
        this.negative = negative;
    }
}
