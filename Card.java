package task.models;

public class Card {
    public final String title;
    public final String description;
    public final int[] effects;
    public final String positive;
    public final String negative;
    public Card(String title, String description, int[] effects, String positive, String negative) {
        this.title = title;
        this.description = description;
        this.effects = effects;
        this.positive = positive;
        this.negative = negative;
    }
}
