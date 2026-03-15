package blackjack;

<<<<<<< HEAD
import blackjack.controller.BlackjackController;
import blackjack.domain.deck.Deck;
import blackjack.service.GameService;
import blackjack.view.InputView;
=======
import blackjack.config.AppConfig;
import blackjack.controller.BlackjackController;
import blackjack.util.Console;
>>>>>>> upstream/kangrae-jo

public class Application {

    public static void main(String[] args) {
<<<<<<< HEAD
        BlackjackController controller = new BlackjackController(new GameService(new Deck()), new InputView());
        controller.run();
    }
=======
        try {
            AppConfig config = new AppConfig();
            BlackjackController controller = config.controller();
            controller.run();
        } finally {
            Console.close();
        }
    }

>>>>>>> upstream/kangrae-jo
}
