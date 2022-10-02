package baseball.view;

import baseball.domain.PlayResult;
import baseball.util.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
    public static List<Integer> inputBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        validateInput(input);
        return Utils.generateInputNumbers(input);
    }

    private static void validateInput(String input) {
        if (!Utils.isNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (input.length() > Utils.MAX_BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void printResult(PlayResult result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (result.getBall() > 0) {
            sb.append(result.getBall()).append("볼 ");
        }
        if (result.getStrike() > 0) {
            sb.append(result.getStrike()).append("스트라이크");
        }
        System.out.println(sb);
    }

    public static boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (!Utils.isNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}