package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.util.Utils;
import baseball.view.GameView;

public class GameController {
    public void start() {
        do {
            Balls computerBalls = new Balls(Utils.generateNumber());
            playGame(computerBalls);
            GameView.printGameEnd();
        } while (GameView.isRestart());
    }

    private static void playGame(Balls computerBalls) {
        PlayResult result;
        do {
            result = computerBalls.play(GameView.inputBalls());
            GameView.printResult(result);
        } while (!result.isEnd());
    }
}
