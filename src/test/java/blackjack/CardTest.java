package blackjack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CardTest {

    @Test
    void 카드는_카드_값으로부터_점수를_계산할_수_있다() {
        Card card1 = new Card("5");
        Card card2 = new Card("A");
        Card card3 = new Card("K");

        int score1 = card1.calculateScore();
        int score2 = card2.calculateScore();
        int score3 = card3.calculateScore();

        assertEquals(5, score1);
        assertEquals(1, score2);
        assertEquals(10, score3);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2", "5", "10"})
    void 카드가_숫자일때_2부터_10까지의_숫자_이어야_한다(String input) {
        assertDoesNotThrow(() -> new Card(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "J", "Q", "K"})
    void 카드가_알파벳일때_A_J_Q_K_이어야_한다(String input) {
        assertDoesNotThrow(() -> new Card(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "11"})
    void 카드가_숫자일때_2부터_10까지의_숫자가_아니면_오류를_일으킨다(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Card(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"B", "a", "b", "x"})
    void 카드가_알파벳일때_A_J_Q_K가_아니면_오류를_일으킨다(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Card(input));
    }

}