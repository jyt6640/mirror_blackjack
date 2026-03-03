package blackjack;

import java.util.Scanner;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        
        Card card = new Card(input);

        int scoreOfCard = getScoreOfCard(card);
        System.out.println("score of the card : " + scoreOfCard);
    }

    private static int getScoreOfCard(Card card) {
        return card.calculateScore();
    }

}
