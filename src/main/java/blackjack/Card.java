package blackjack;

public class Card {

    private final String value;

    public Card(String number) {
        this.value = number;
    }

    public int calculateScore() {
        if (value.equals("A")) {
            return 1;
        }
        if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            return 10;
        }
        return Integer.parseInt(value);
    }

}
