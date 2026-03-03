package blackjack;

public class Card {

    private final String value;

    public Card(String value) {
        validateValue(value);
        this.value = value;
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

    private void validateValue(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("카드 값은 비어있지 않아야 합니다.");
        }

        try {
            int parsed = Integer.parseInt(value);
            if (2 > parsed || parsed > 10) {
                throw new IllegalArgumentException("카드 값이 숫자라면 2부터 10까지의 수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            if (!value.equals("A") && !value.equals("J") && !value.equals("Q") && !value.equals("K")) {
                throw new IllegalArgumentException("카드 값이 알파벳이라면 A, J, Q, K 중 하나여야 합니다.");
            }
        }
    }

}
