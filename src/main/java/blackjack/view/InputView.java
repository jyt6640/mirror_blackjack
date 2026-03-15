package blackjack.view;

import blackjack.util.Console;
<<<<<<< HEAD

public class InputView {

    public String readUserName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Console.readLine();
=======
import java.util.List;

public class InputView {

    public List<String> readPlayersName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String playersName = Console.readLine();
        try {
            return List.of(playersName.split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException("플레이어 이름을 쉽표로 구분된 문자열로 입력하세요.");
        }
>>>>>>> upstream/kangrae-jo
    }

    public String readMoreCard(String userName) {
        System.out.println(userName + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return Console.readLine();
    }

<<<<<<< HEAD
    public String readBettingAmount(String userName) {
        System.out.println();
        System.out.println(userName + "의 배팅 금액은?");
        return Console.readLine();
    }
=======
>>>>>>> upstream/kangrae-jo
}
