package blackjack.controller;

<<<<<<< HEAD
import static blackjack.util.constant.Constants.GET_MORE_CARD_BUTTON;

import blackjack.domain.BettingAmount;
import blackjack.domain.participant.Dealer;
import blackjack.domain.GameResult;
import blackjack.domain.participant.User;
import blackjack.domain.participant.Users;
import blackjack.service.GameService;
import blackjack.util.InputParser;
=======
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.dto.WinningResult;
>>>>>>> upstream/kangrae-jo
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackjackController {

<<<<<<< HEAD
    private final GameService gameService;
    private final InputView inputView;

    public BlackjackController(GameService gameService, InputView inputView) {
        this.gameService = gameService;
=======
    private final InputView inputView;

    public BlackjackController(InputView inputView) {
>>>>>>> upstream/kangrae-jo
        this.inputView = inputView;
    }

    public void run() {
<<<<<<< HEAD
        try {
            Users users = createUsers();
            Dealer dealer = new Dealer();

            gameService.settingCards(users, dealer);
            printGameSettingResult(users, dealer);

            getMoreCards(users);
            if (!users.isAllBurst()) {
                getMoreCardsForDealer(dealer);
            }

            printGameResult(users, dealer);
            printWinningResult(users, dealer);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private Users createUsers() {
        List<String> userNames = InputParser.parseUser(inputView.readUserName());
        List<User> users = userNames.stream()
                .map(name -> new User(name, readBetting(name)))
                .toList();
        return new Users(users);
    }

    private BettingAmount readBetting(String name) {
        String input = inputView.readBettingAmount(name);
        int amount = InputParser.parseBettingAmount(input);
        return new BettingAmount(amount);
    }

    private void printGameSettingResult(Users users, Dealer dealer) {
        OutputView.printGameSettingMessage(dealer.getName(), users.getNames());
        OutputView.printSettingCardsResult(dealer.getName(), List.of(dealer.getFirstCardName()));
        users.forEach(user ->
                OutputView.printSettingCardsResult(user.getName(), user.getCardsName())
        );
        OutputView.printEmptyLine();
    }

    private void getMoreCards(Users users) {
        users.forEach(this::processUserTurn);
    }

    private void processUserTurn(User user) {
        drawIfWanted(user);
        OutputView.printSettingCardsResult(user.getName(), user.getCardsName());
    }

    private void drawIfWanted(User user) {
        while (!user.isFinished() && GET_MORE_CARD_BUTTON.equals(inputView.readMoreCard(user.getName()))) {
            gameService.getMoreCard(user);
            OutputView.printSettingCardsResult(user.getName(), user.getCardsName());
        }
    }

    private void getMoreCardsForDealer(Dealer dealer) {
        OutputView.printEmptyLine();
        while (dealer.shouldDrawCard()) {
            OutputView.printGetMoreCardsForDealer(dealer.getName());
            gameService.getMoreCard(dealer);
        }
    }

    private void printGameResult(Users users, Dealer dealer) {
        OutputView.printCardsResult(dealer.getName(), dealer.getCardsName(), dealer.calculateCardsValue());
        users.forEach(user ->
                OutputView.printCardsResult(user.getName(), user.getCardsName(), user.calculateCardsValue())
        );
    }

    private void printWinningResult(Users users, Dealer dealer) {
        GameResult gameResult = new GameResult();
        OutputView.printEmptyLine();
        users.forEach(user ->
                gameService.applyGameResult(user, dealer, gameResult)
        );
        OutputView.printWinningResult(gameResult, dealer.getName());
    }
=======
        Players players = readPlayers();
        Player dealer = new Player("딜러");

        setInitialTwoCards(players, dealer);
        printInitialSettings(players, dealer);

        getMoreCardsForPlayers(players);
        getMoreCardsForDealer(dealer, players);

        printGameResult(players, dealer);
        printWinningResult(players, dealer);
    }

    private Players readPlayers() {
        List<String> playersName = inputView.readPlayersName();
        return Players.from(playersName);
    }

    private void setInitialTwoCards(Players players, Player dealer) {
        Deck.shuffle();
        for (int i = 0; i < 2; i++) {
            players.draw();
            dealer.draw(Deck.pop());
        }
    }

    private void printInitialSettings(Players players, Player dealer) {
        OutputView.printInitialSettingsDoneMessage(dealer.getName(), players.getPlayersName());
        OutputView.printCardResults(dealer.getName(), List.of(dealer.getFirstCardName()));
        for (Player player : players.getPlayers()) {
            OutputView.printCardResults(player.getName(), player.getCardsName());
        }
        OutputView.println();
    }

    private void getMoreCardsForPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            getMoreCardsForPlayer(player);
        }
    }

    private void getMoreCardsForPlayer(Player player) {
        boolean isDraw = false;
        while (!player.isBurst() && !player.isBlackjack() && readPlayerWantMoreCard(player)) {
            player.draw(Deck.pop());
            OutputView.printCardResults(player.getName(), player.getCardsName());
            isDraw = true;
        }
        if (!isDraw) {
            OutputView.printCardResults(player.getName(), player.getCardsName());
        }
    }

    private boolean readPlayerWantMoreCard(Player player) {
        return "y".equals(inputView.readMoreCard(player.getName()));
    }

    private void getMoreCardsForDealer(Player dealer, Players players) {
        if (players.isAllPlayersBurst()) {
            return;
        }
        while (dealer.calculateCardsValue() < 17) {
            dealer.draw(Deck.pop());
            OutputView.printGetMoreCardsMessageForDealer(dealer.getName());
        }
    }

    private void printGameResult(Players players, Player dealer) {
        OutputView.println();
        OutputView.printCardResults(dealer.getName(), dealer.getCardsName(), dealer.calculateCardsValue());
        for (Player player : players.getPlayers()) {
            OutputView.printCardResults(player.getName(), player.getCardsName(), player.calculateCardsValue());
        }
    }

    private void printWinningResult(Players players, Player dealer) {
        OutputView.printWinningResult(WinningResult.from(players, dealer));
    }

>>>>>>> upstream/kangrae-jo
}
